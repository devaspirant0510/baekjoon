import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        HashSet<String> checkDiffStrings = new HashSet<>();
        // 조합할수 있는 경우의수 전체 탐색에서 셋에 넣어 중복제거
        // 최대가 1000이기떄문에 시간복잡도가 O(n^3) 이더라도 가능
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j <input.length() ; j++) {
                for (int k = i; k <=j; k++) {
                    sb.append(input.charAt(k));
                }
                checkDiffStrings.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        System.out.println(checkDiffStrings.size());
    }
}
