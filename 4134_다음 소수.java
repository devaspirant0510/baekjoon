import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long el = Long.parseLong(br.readLine());
            if(el<=2){
                System.out.println(2);
                continue;
            }
            if(el==4_000_000_000L){
                System.out.println(4_000_000_007L);
                continue;
            }
            if(el%2==0){
                el++;
            }
            for (long j = el; j < 4_000_000_000L; j+=2) {
                boolean isPrimeN = true;
                for (int k = 2; k < Math.sqrt(j) + 1; k++) {
                    if(j%2==0){
                        isPrimeN=false;
                        break;
                    }
                    if(j%k==0){
                        isPrimeN = false;
                        break;
                    }
                }
                if(isPrimeN){
                    System.out.println(j);
                    break;
                }


            }

        }


    }
}
