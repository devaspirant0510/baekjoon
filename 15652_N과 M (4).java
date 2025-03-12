/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 15652
 * 📌 문제 제목  : N과 M (4)
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/15652
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-12
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        nCr(0,0,n,m,arr,new ArrayList<>());

    }
    protected static void nCr(int start,int depth,int n, int r, int[] arr, List<Integer> output){
        if (depth==r){
            for (int i:output){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for (int i =start ; i < n; i++) {
            output.add(arr[i]);
            nCr(i,depth+1,n,r,arr,output);
            output.remove(output.size()-1);

        }

    }
}
