import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] arr;
    static int n, m;
    static Queue<Pos> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int chess = Integer.parseInt(st.nextToken());

                arr[i][j] = chess;
            }
        }

        int time = 0;
        ArrayList<Pos> meltList = new ArrayList<>();
        while (true) {meltList = new ArrayList<>();
            visited = new boolean[n][m];
            // 외부 공기 찾기
            dfs(0,0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && isMelt(i,j)) {
                        meltList.add(new Pos(i,j));
                    }
                }
            }

            if(meltList.isEmpty()){
                System.out.println(time);
                return;
            }
            for (Pos pos:meltList) {
                arr[pos.y][pos.x] = 0;
            }
            time++;
        }

    }

    protected static boolean isMelt(int y, int x) {
        int count =0;
        for (int i = 0; i < 4; i++) {
            int goY = dy[i] + y;
            int goX = dx[i] + x;
            if(0<=goX && goX<m && 0<=goY && goY<n){
                // 주변이 공기인경우
                if(visited[goY][goX]){
                    count++;
                }

            }

        }
        return count >= 2;
    }

    protected static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Pos remove = queue.remove();
            int x = remove.x;
            int y = remove.y;
            for (int i = 0; i < 4; i++) {
                int goX = x + dx[i];
                int goY = y + dy[i];

                if ((0 <= goX && goX < m) && (0 <= goY && goY < n)) {
                    if (!visited[goY][goX] && arr[goY][goX] == 0) {
                        queue.add(new Pos(goY, goX));
                        visited[goY][goX] = true;
                    }

                }
            }
        }
    }

    protected static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int goX = x + dx[i];
            int goY = y + dy[i];

            if ((0 <= goX && goX < m) && (0 <= goY && goY < n)) {
                if (!visited[goY][goX] && (arr[goY][goX] == 0)) {
                    dfs(goY, goX);

                }

            }

        }

    }

    protected static class Pos {
        private int y;
        private int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}