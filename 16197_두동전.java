import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int COIN = 1;
    static int ROAD = 2;
    static int WALL = 3;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        int inputAx = 0, inputAy=0, inputBx=0, inputBy=0;
        int coin = 0;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                String el = String.valueOf(row.charAt(j));
                switch (el) {
                    case "o":
                        if (coin == 0) {
                            inputAx = j;
                            inputAy = i;
                            coin++;
                        } else {
                            inputBx = j;
                            inputBy = i;
                        }
                        arr[i][j] = COIN;
                        visited[i][j] = true;
                        break;
                    case ".":
                        arr[i][j] = ROAD;
                        break;
                    case "#":
                        arr[i][j] = WALL;
                        break;
                }
            }
        }
        dfs(inputAx,inputAy,inputBx,inputBy,0);
    }

    static void dfs(int ax, int ay, int bx, int by, int count) {
        for (int i = 0; i < 4; i++) {
            int goAX = dx[i] + ax;
            int goAY = dy[i] + ay;
            int goBx = dx[i] + bx;
            int goBy = dy[i] + by;
            boolean flag = false;
            boolean isOut = false;
            if ((goAX < 0 || goAX >= m) || (goAY < 0 || goAY >= n)) {
                flag = !flag;
                isOut = true;
            }
            if ((goBx < 0 || goBx >= m) || (goBy < 0 || goBy >= n)) {
                flag = !flag;
                isOut = true;
            }
            if (flag) {
                System.out.println(count);
                return;
            }
            if(isOut){
                continue;
            }
            // 벽있으면 원위치
            if (arr[goAY][goAX] == WALL) {
                goAX = ax;
                goAY = ay;
            }
            if (arr[goBy][goBx] == WALL) {
                goBx = bx;
                goBy = by;
            }
            if (visited[goAY][goAX] && visited[goBy][goBx]) {
                continue;
            }
            visited[goAY][goAX] = true;
            visited[goBy][goBx] = true;
            dfs(goAX, goAY, goBx, goBy, count + 1);
            visited[goAY][goAX] = false;
            visited[goBy][goBx] = false;


        }

    }


}
