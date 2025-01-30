import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N-1; i >=1; i--) {
            arr[i] = arr[i]-arr[i-1];
        }
        int gcdValue = arr[1];
        for (int i = 1; i < N ; i++) {
            if(arr[i]==1){
                gcdValue=1;
                break;
            }
            gcdValue = gcd(gcdValue,arr[i]);
        }
        int sum =0 ;
        for (int i = 1; i < N; i++) {
            sum+=arr[i]/gcdValue-1;
        }
        System.out.println(sum);


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

}
