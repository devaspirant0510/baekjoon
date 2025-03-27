/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 12891
 * 📌 문제 제목  : 
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/12891
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-28
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 11 5
        // AAACCTGCCAA
        //-----
        // 3 0 0 0
        // 1
        // 1 1 1 1
        // 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String st = br.readLine();
        char[] arr = new char[n];
        int[] minDnaCount = new int[4];
        boolean[] isDna = new boolean[n];
        int[] currentDnaStatus = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = st.charAt(i);
        }
        String[] dnaCount = br.readLine().split(" ");
        minDnaCount[0] = Integer.parseInt(dnaCount[0]);
        minDnaCount[1] = Integer.parseInt(dnaCount[1]);
        minDnaCount[2] = Integer.parseInt(dnaCount[2]);
        minDnaCount[3] = Integer.parseInt(dnaCount[3]);

        for (int i = 0; i < m; i++) {
            if (arr[i] == 'A') {
                currentDnaStatus[0]++;
            } else if (arr[i] == 'C') {
                currentDnaStatus[1]++;
            } else if (arr[i] == 'G') {
                currentDnaStatus[2]++;
            } else if (arr[i] == 'T') {
                currentDnaStatus[3]++;
            }
        }
        int count = 0;
        count+=validDNApassword(currentDnaStatus,minDnaCount)?1:0;
        for (int i = 1; i <=n-m ; i++) {
            switch (arr[i-1]){
                case 'A':
                    currentDnaStatus[0]--;
                    break;
                case 'C':
                    currentDnaStatus[1]--;
                    break;
                case 'G':
                    currentDnaStatus[2]--;
                    break;
                default:
                    currentDnaStatus[3]--;
                    break;
            }
            switch (arr[i-1+m]){
                case 'A':
                    currentDnaStatus[0]++;
                    break;
                case 'C':
                    currentDnaStatus[1]++;
                    break;
                case 'G':
                    currentDnaStatus[2]++;
                    break;
                default:
                    currentDnaStatus[3]++;
                    break;
            }
            count+=validDNApassword(currentDnaStatus,minDnaCount)?1:0;

        }
        System.out.println(count);

    }
    protected static  boolean validDNApassword(int[] currentStatus,int[] ordinary){
        for (int i = 0; i < 4; i++) {
            if(ordinary[i]>currentStatus[i]){
                return false;
            }
        }
        return true;
    }
}
