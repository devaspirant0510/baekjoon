/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 15650
 * 📌 문제 제목  : N과 M (2)
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/15650
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-09
 ============================================================================*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        String[] line =br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = i+1;
        }
        nCr(n,r,0,arr,new ArrayList<>());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    protected static void nCr(int n, int r, int start, int[] arr, List<Integer> output){
        if(r==0){
            for(int el:output){
                sb.append(el).append(" ");

            }
            sb.append("\n");
        }
        for (int i = start; i < n; i++) {
            output.add(arr[i]);
            nCr(n,r-1,i+1,arr,output);
            output.remove(output.size()-1);
        }

    }
}
