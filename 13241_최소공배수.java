import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long originA = a;
        long originB = b;
        a = Math.max(originA, originB);
        b = Math.min(originA, originB);
        long r;
        while (true) {
            r=a%b;
            if(r==0){
                break;
            }
            a=b;
            b=r;

        }
        System.out.println((originA*originB)/b);

    }
}
