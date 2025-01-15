import java.io.*;
import java.util.*;

public class Main {
    private static int X, Y, H;
    private static int[][][] tomato;
    private static final int[] dx = {1, -1, 0, 0, 0, 0};
    private static final int[] dy = {0, 0, 1, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        X = Integer.parseInt(tokenizer.nextToken());
        Y = Integer.parseInt(tokenizer.nextToken());
        H = Integer.parseInt(tokenizer.nextToken());

        tomato = new int[H][Y][X];
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++) {
                    tomato[h][y][x] = Integer.parseInt(tokenizer.nextToken());
                    if (tomato[h][y][x] == 1) {
                        queue.add(new int[]{x, y, h});
                    }
                }
            }
        }

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curZ = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nz = curZ + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < X && ny < Y && nz < H) {
                    if (tomato[nz][ny][nx] == 0) {
                        tomato[nz][ny][nx] = tomato[curZ][curY][curX] + 1;
                        queue.add(new int[]{nx, ny, nz});
                    }
                }
            }
        }

        // 결과 계산
        int maxDays = 0;
        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (tomato[h][y][x] == 0) { // 익지 않은 토마토가 남아 있으면
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, tomato[h][y][x]);
                }
            }
        }

        // 익는 데 걸린 최대 일수 출력 (초기값 1을 빼줌)
        System.out.println(maxDays - 1);
    }
}

