import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine()) / 10;
            count[n]++;
            sum += n;
        }

        int median = 0;
        int countSum = 0;
        for (int i = 9; i >= 0; i--) {
            countSum += count[i];
            if (countSum >= 3) {
                median = i * 10;
                break;
            }
        }

        System.out.println(sum * 10 / 5); // 평균 계산
        System.out.println(median); // 중앙값
    }
}
