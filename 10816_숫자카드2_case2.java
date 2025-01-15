import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cardCount = new int[20_000_001];
        int ARRAY_MAX = 10_000_000;

        // 입력
        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int el = Integer.parseInt(cards[i]);
            cardCount[el + ARRAY_MAX]++;
        }

        int M = Integer.parseInt(br.readLine());
        String[] queries = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int el = Integer.parseInt(queries[i]);
            sb.append(cardCount[el + ARRAY_MAX]).append(" ");
        }

        // 출력
        System.out.println(sb.toString().trim());
    }
}

