/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 11660
 * 📌 문제 제목  : 구간 합 구하기 5
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/11660
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-14
 ============================================================================*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] arr = new int[n][n];
        int[][] sum = new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum[1][1] = arr[0][0];
        for (int i = 2; i < n+1; i++) {
            sum[1][i] = sum[1][i-1 ] + arr[0][i-1];
        }
        for (int i = 2; i < n+1; i++) {
            sum[i][1] = sum[i -1][1] + arr[i-1][0];

        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sum[i+1][j+1] = arr[i][j] + sum[i ][j+1] + sum[i+1][j ] - sum[i ][j ];
            }
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int ly = Integer.parseInt(line[0]) ;
            int lx = Integer.parseInt(line[1]) ;
            int ry = Integer.parseInt(line[2]) ;
            int rx = Integer.parseInt(line[3]) ;

            bw.write(sum[ry][rx]-sum[ly-1][rx]-sum[ry][lx-1]+sum[ly-1][lx-1]+"\n");
        }
        bw.flush();
        bw.close();

    }

}
