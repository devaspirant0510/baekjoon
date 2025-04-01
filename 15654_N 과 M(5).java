/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 15654
 * 📌 문제 제목  : N과 M (5)
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/15654
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-01
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line  =  br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        combination(0,arr,n,m,new ArrayList<>(),new boolean[n]);


    }
    protected static void combination(int start, int[] arr, int size,int depth, List<Integer> output,boolean[] visited){
        if(output.size()==depth){
            output.forEach(integer -> System.out.print(integer+" "));
            System.out.println();
            return;
        }
        for (int i = 0; i < size; i++) {
            if(!visited[i]){
                visited[i] = true;
                output.add(arr[i]);
                combination(start+1,arr,size,depth,output,visited);
                output.remove(output.size()-1);
                visited[i] = false;
            }
        }




    }
}
