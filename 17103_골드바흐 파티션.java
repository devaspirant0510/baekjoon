import java.io.*;
import java.util.*;

public class Main {
    private static boolean TRUE = false;
    private static boolean FALSE = true;
    private static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arache = new boolean[MAX];
        // 0,1 는 소수가 아님
        arache[0] = arache[1] = FALSE;

        for (int i = 2; i * i < MAX; i++) {
            if (arache[i] == TRUE) {
                for (int j = i * i; j < MAX; j += i) {
                    arache[j] = FALSE;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(br.readLine());
            int count = 0;
            // 절반값이 소수인지 :  6이면 절반인 3(3+3=6) 이 소수인지
            if (arache[el / 2] == TRUE) {
                count++;
            }
            for (int j = 2; j < el / 2; j++) {
                if (arache[j] == TRUE && arache[el - j] == TRUE) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);

    }
}
