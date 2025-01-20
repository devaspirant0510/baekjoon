import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int a = Integer.parseInt(st[0]);
        int b = Integer.parseInt(st[1]);
        int c = Integer.parseInt(st[2]);


        int max = Math.max(Math.max(a, b), c);
        int sum = a + b + c;

        // max = Max(a,b,c) 길이가 가장 긴 밑변
        // 밑변이 나머지 두변의 합보다 클경우 밑변을 줄여야됨 => 정확히 두변의 합 -1 = 밑변의 길이
        // 즉 이 매커니즘은  밑변의 길이 + 두변의 합 이고 밑변의 길이가 두변의 합 -1 이므로 (두 변의 합 * 2) -1 을 하면됨
        // 밑변이 max 이기때문에 나머지 두변의 합은 a+b+c-max
        // 두변의 합 * 2 -1 을 하면 됨
        if (sum - max <= max) {
            System.out.println(2 * (sum - max) - 1);
        } else {
            System.out.println(sum);
        }
    }
}
