import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cardCount = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int el = Integer.parseInt(st.nextToken());
            cardCount.merge(el, 1, Integer::sum);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int el = Integer.parseInt(st.nextToken());
            sb.append(cardCount.getOrDefault(el, 0)).append(" ");
        }

        // 출력
        System.out.println(sb.toString().trim());
    }
}

