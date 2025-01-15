import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        
        Arrays.sort(str, (s1, s2) -> {
            int l1 = s1.length(), l2 = s2.length();
            if (l1 == l2) {
                return s1.compareTo(s2);
            }
            return l1 - l2;
        });
        
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]).append('\n');
        for (int i = 1; i < N; i++) {
            if (!str[i].equals(str[i - 1])) {
                sb.append(str[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
}

