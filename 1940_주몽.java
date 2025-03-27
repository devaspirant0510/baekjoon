/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 1940
 * 📌 문제 제목  : 주몽
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/1940
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-27
 ============================================================================*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start =0;
        int end= n-1;
        int count = 0;
        while(start<end){
            if(arr[start]+arr[end]==m){
                count++;
                start++;
                end--;
            }
            else if(arr[start]+arr[end]<m){
                start++;
            }else{
                end--;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
