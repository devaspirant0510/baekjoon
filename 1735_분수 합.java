import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int topA = Integer.parseInt(st.nextToken());
        int bottomA = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int topB = Integer.parseInt(st.nextToken());
        int bottomB = Integer.parseInt(st.nextToken());
        // 1. 두 분모의 최대공약수구함
        // 2. 연산결과 분모는 방금구한 최대공약수
        // 3. 분자는 최대공약수/분모 * 분자 의 값을 더한결과
        int getLcd = lcd(bottomA,bottomB);
        int tempA = getLcd/bottomA;
        int tempB = getLcd/bottomB;
        int topResult = tempA*topA+tempB*topB;
        int[] result = medicineMinute(topResult, getLcd);
        System.out.println(result[0]+" "+result[1]);

    }

    protected static int[] medicineMinute(int p1, int p2) {
        int[] result = new int[2];
        // 각각의 수를 최대공약수 나누기
        int resultGcd = gcd(p1, p2);
        if (resultGcd == 1) {
            result[0] = p1;
            result[1] = p2;

        } else {
            result[0] = p1 / resultGcd;
            result[1] = p2 / resultGcd;
        }
        return result;

    }

    protected static int gcd(int p1, int p2) {
        int a = Math.max(p1, p2);
        int b = Math.min(p1, p2);
        int r;
        while (true) {
            r = a % b;
            if (r == 0) {
                break;
            }
            a = b;
            b = r;

        }
        return b;
    }

    // 유클리드 호제법을 이용한 최소공배수 구하기
    protected static int lcd(int p1, int p2) {
        return (p1 * p2) / gcd(p1, p2);
    }

}
