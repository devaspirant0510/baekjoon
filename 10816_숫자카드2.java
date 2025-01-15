import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine());
        String[] inputCards = br.readLine().split(" ");
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            int el = Integer.parseInt(inputCards[i]);
            card[i] = el;
        }
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        String[] queries = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int el = Integer.parseInt(queries[i]);
            int end = binSearchUpperBound(card, N, el);
            int start = binSearchLowerBound(card, N, el);
            if (start == -1 || end == -1 || start == end) {
                sb.append("0 ");
            } else {
                sb.append(end - start).append(" ");
            }
        }

        // 출력
        System.out.println(sb.toString().trim());
    }

    // Lower Bound: findValue가 처음 나오는 위치
    static int binSearchLowerBound(int[] card, int size, int findValue) {
        int start = 0;
        int end = size;

        while (start < end) {
            int mid = (start + end) / 2;

            if (card[mid] < findValue) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // 찾을 값이 존재하면 그 위치를, 아니면 -1 반환
        if (start < size && card[start] == findValue) {
            return start;
        }

        return -1; // 값이 존재하지 않으면 -1
    }

    // Upper Bound: findValue보다 큰 값이 처음 나오는 위치
    static int binSearchUpperBound(int[] card, int size, int findValue) {
        int start = 0;
        int end = size;

        while (start < end) {
            int mid = (start + end) / 2;

            if (card[mid] <= findValue) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // findValue보다 큰 값이 처음 나오는 위치
    }
}

