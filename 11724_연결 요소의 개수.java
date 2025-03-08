import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};
    protected static int[][] arr;
    protected static boolean[] visited;
    protected static Queue<Integer> queue;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]) - 1;
            int b = Integer.parseInt(st[1]) - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        int count = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 방문 한적이 없는데 나온다면 새로운 간선임
            if (!visited[i]) {
                count++;
            }
            visited[i] = true;
            queue.add(i);
            bfs(i);
            queue.clear();

        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    protected static void bfs(int start) {
        while (!queue.isEmpty()) {
            int popValue = queue.remove();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && arr[popValue][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }

            }
        }


    }

    protected static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[start][i] == 1) {
                dfs(i);
            }
        }
    }

}