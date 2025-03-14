/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 11659
 * 📌 문제 제목  : 구간 합 구하기 4
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/11659
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
        int[] arr = new int[n];
        int[] sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(st.nextToken());
            arr[i] = el;
            sum[i + 1] = arr[i]+sum[i];
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sum[end] - sum[start - 1]);

        }

    }
}
