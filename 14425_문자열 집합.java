import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Boolean> check =new HashMap<>();
        for (int i = 0; i < N; i++) {
            check.put(br.readLine(),true);
        }
        int c = 0;
        for (int i = 0; i < M; i++) {
            if(check.get(br.readLine())!=null){
                c++;
            }

        }
        System.out.println(c);
    }
}
