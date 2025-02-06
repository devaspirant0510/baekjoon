import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> vector = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            if (left == 1) {
                int right = Integer.parseInt(st.nextToken());
                vector.add(0, right);
            } else if (left == 2) {
                int right = Integer.parseInt(st.nextToken());
                vector.add(right);
            } else if (left == 3) {
                if (vector.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(vector.get(0)).append("\n");
                    vector.remove(0);
                }
            } else if (left == 4) {
                if (vector.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    int size = vector.size() - 1;
                    sb.append(vector.get(size)).append("\n");
                    vector.remove(size );
                }

            } else if (left == 5) {
                sb.append(vector.size()).append("\n");
            } else if (left == 6) {
                sb.append(vector.isEmpty() ? 1 : 0).append("\n");
            } else if (left == 7) {
                if (vector.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(vector.get(0)).append("\n");
                }
            } else {

                if (vector.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    int size = vector.size() - 1;
                    sb.append(vector.get(size)).append("\n");
                }
            }

        }
        System.out.println(sb);

    }

}
