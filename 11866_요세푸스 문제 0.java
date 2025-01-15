import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 입력
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        // 큐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K-1; j++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll().toString());

        }
        System.out.println("<"+String.join(", ", result)+">");

    }



}

