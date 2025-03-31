/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 12865
 * 📌 문제 제목  : 평범한 배낭
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/12865
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-01
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[][] dp = new int[n+1][k+1];
        int[] weights = new int[n+1];
        int[] values = new int[n+1];
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            int w = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            weights[i] = w;
            values[i] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // 넣을물건 없을땐 이전값 그대로 넣기
                if(weights[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 이전 물건값 vs 이전 물건의 무게 - 현재물건의 무게 한 이전 물건밸류 + 현재 인덱스의 물건 밸류
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
