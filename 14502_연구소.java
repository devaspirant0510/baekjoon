import java.io.*;
import java.util.*;

public class Main {
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};
    protected static int[][] arr;
    protected static int[][] tempArr;
    protected static boolean[][] visited;
    protected static boolean[][] tempVisited;
    protected static List<List<Integer>> wallPick;
    protected static Queue<Pos> queue;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        wallPick = new ArrayList<>();
        queue = new LinkedList<>();
        StringTokenizer st;
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n][m];
        tempArr = new int[n][m];
        visited = new boolean[n][m];
        List<Pos> virusArr = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int el = Integer.parseInt(st.nextToken());
                if (el == 0) {
                    list.add(i * m + j);
                }
                if (el == 2) {
                    virusArr.add(new Pos(i, j));
                }
                if (el == 1) {
                    visited[i][j] = true;
                }
                arr[i][j] = el;
            }
        }
        nCr(list.size(), 3, list, new ArrayList<>(), 0);
        tempVisited = new boolean[n][m]; // 새로운 배열 생성
        for (int i = 0; i < n; i++) {
            tempVisited[i] = visited[i].clone(); // 한 행씩 복사 (깊은 복사)
        }
        for (int i = 0; i < n; i++) {
            tempArr[i] = arr[i].clone();

        }
        int minCount = -99999999;
        for (List<Integer> tempWall : wallPick) {
            for (int i = 0; i < n; i++) {
                visited[i] = tempVisited[i].clone(); // 한 행씩 복사 (깊은 복사)
                arr[i] = tempArr[i].clone();
            }

            for (int wall : tempWall) {
                arr[wall / m][wall % m] = 1;
                visited[wall / m][wall % m] = true;
            }
            queue.addAll(virusArr);
            bfs();
            int c = countBlank();
            if(minCount<c){
                minCount = c;
            }


            queue.clear();
            for (int wall : tempWall) {
                arr[wall / m][wall % m] = 0;
                visited[wall / m][wall % m] = false;
            }
        }
        System.out.println(minCount);
    }

    private static int countBlank() {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    c++;

                }
            }

        }
        return c;
    }

    protected static void bfs() {
        while (!queue.isEmpty()) {
            Pos pos = queue.remove();
            visited[pos.getY()][pos.getX()] = true;
            for (int i = 0; i < 4; i++) {
                int goY = pos.getY() + dy[i];
                int goX = pos.getX() + dx[i];
                if (0 <= goX && goX < m && 0 <= goY && goY < n) {
                    if (!visited[goY][goX] && arr[goY][goX] == 0) {
                        arr[goY][goX] = 2;
                        queue.add(new Pos(goY, goX));
                    }
                }
            }
        }
    }

    protected static void nCr(int n, int r, List<Integer> list, List<Integer> output, int start) {
        if (r == 0) {
            wallPick.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i < n; i++) {
            output.add(list.get(i));
            nCr(n, r - 1, list, output, i + 1);
            output.remove(output.size() - 1);

        }
    }

    static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
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