import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] goX = {1, -1, 0, 0};
    static int[] goY = {0, 0, 1, -1};
    static int N, M;
    static int maxValue = -181818;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                checkedTM(arr,visited,i,j,arr[i][j],0);
                visited[i][j] = false;
                checkTShape(i,j);
            }
        }
        System.out.println(maxValue);
    }

    protected static void checkedTM(int[][] arr, boolean[][] visited, int y, int x, int sum, int c) {
        if (c == 3) {
            if (maxValue < sum) {
                maxValue = sum;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int gx = x + goX[i];
            int gy = y + goY[i];
            if(0<=gx && gx<M && 0<=gy && gy<N){
                if(visited[gy][gx]){
                    continue;
                }
                visited[gy][gx] = true;
                checkedTM(arr,visited,gy,gx,sum+arr[gy][gx],c+1);
                visited[gy][gx] = false;

            }

        }
    }
    protected static void checkTShape(int y, int x) {
        // ㅜ
        if (y >= 0 && y < N - 1 && x >= 1 && x < M - 1) {
            int sum = arr[y][x] + arr[y][x - 1] + arr[y][x + 1] + arr[y + 1][x];
            maxValue = Math.max(maxValue, sum);
        }
        // ㅏ
        if (y >= 1 && y < N - 1 && x >= 0 && x < M - 1) {
            int sum = arr[y][x] + arr[y - 1][x] + arr[y + 1][x] + arr[y][x + 1];
            maxValue = Math.max(maxValue, sum);
        }
        // ㅗ
        if (y >= 1 && y < N && x >= 1 && x < M - 1) {
            int sum = arr[y][x] + arr[y - 1][x] + arr[y][x - 1] + arr[y][x + 1];
            maxValue = Math.max(maxValue, sum);
        }
        // ㅓ
        if (y >= 1 && y < N - 1 && x >= 1 && x < M) {
            int sum = arr[y][x] + arr[y - 1][x] + arr[y + 1][x] + arr[y][x - 1];
            maxValue = Math.max(maxValue, sum);
        }
    }
}
