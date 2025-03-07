import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n][n];
        boolean[] visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b - 1][a - 1] = true;
            graph[a - 1][b - 1] = true;

        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int c = 0;
        while (!queue.isEmpty()) {
            int virus = queue.remove();
                for (int i = 0; i < n; i++) {
                    if (graph[virus][i] &&!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        c++;
                    }

                }
        }
        System.out.println(c);

    }
}