import java.io.*;
import java.util.*;

public class Main {
    // 센트 단위로 계산
    private static int QUARTER = 25;
    private static int DIME = 10;
    private static int NIKEL = 5;
    private static int PENNY = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int q,d,n,p = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            q = money/QUARTER;
            money%=QUARTER;

            d = money/DIME;
            money%=DIME;

            n = money/NIKEL;
            money%=NIKEL;

            p = money/PENNY;
            System.out.printf("%d %d %d %d\n",q,d,n,p);

        }
    }
}
