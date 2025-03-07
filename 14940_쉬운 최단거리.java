import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};
    protected static int[][] arr;
    protected static boolean[][] visited;
    protected static Queue<Integer[]> queue;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int el = Integer.parseInt(st.nextToken());
                if (el == 2) {
                    startX = j;
                    startY = i;
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = el;
                }
            }
        }
        Integer[] startPos = {startY, startX};
        visited[startY][startX] = true;
        queue.add(startPos);
//        dfs(startY,startX);
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문 한적이 없지만 길인경우는 도착지점에 못가는 녀석들
                if (!visited[i][j] && arr[i][j] == 1) {
                    sb.append("-1 ");
                } else {
                    sb.append(arr[i][j] + " ");
                }

            }
            sb.append('\n');

        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }

    protected static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] pos = queue.remove();
            for (int i = 0; i < 4; i++) {
                int goY = pos[0] + dy[i];
                int goX = pos[1] + dx[i];
                if (0 <= goX && goX < m && 0 <= goY && goY < n) {
                    if(!visited[goY][goX] && arr[goY][goX]==1){
                        visited[goY][goX] = true;
                        arr[goY][goX] = arr[pos[0]][pos[1]]+1;
                        Integer[] addPos = {goY,goX};
                        queue.add(addPos);
                    }

                }


            }

        }
    }

    protected static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int goX = dx[i] + x;
            int goY = dy[i] + y;
            if (0 <= goX && goX < m && 0 <= goY && goY < n) {
                // 땅 이면서 방문한적 없는경우만 이전 길 +1
                if (arr[goY][goX] == 1 && !visited[goY][goX]) {
                    // 방문한것중에 최솟갑 찾기
                    int minValue = arr[y][x];
                    int preValue = arr[y][x];
                    for (int j = 0; j < 4; j++) {
                        int goXX = dx[j] + goX;
                        int goYY = dy[j] + goY;
                        if (0 <= goXX && goXX < m && 0 <= goYY && goYY < n) {
                            if (visited[goYY][goXX]) {
                                preValue = arr[goYY][goXX];
                                if (minValue > preValue) {
                                    minValue = preValue;
                                }
                            }

                        }

                    }
                    arr[goY][goX] = preValue + 1;
                    dfs(goY, goX);
                }
            }

        }


    }
}