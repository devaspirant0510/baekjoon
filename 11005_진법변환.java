import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        // N = B^x
        // x = log(N)/log(B)
        // x+1 자릿수
        // a*B^x + b*B^(x-1) ... ?*B^0
        int x = (int)(Math.log(N) / Math.log(B));
        StringBuilder sb = new StringBuilder();
        for (int i = x; i>=0 ; i--) {
//            System.out.println(N+" / "+B+"^"+x);
            int header = (int)(N/Math.pow(B,i));
            N = (int)(N%Math.pow(B,i));
            sb.append(convertNum10ToN(header));
            x = (int)(Math.log(N) / Math.log(B));

        }
        System.out.println(sb);
                
        

    }
    protected static String convertNum10ToN(int prefix){
        if(0<=prefix && prefix<10){
            return String.valueOf(prefix);
        }else{
            return String.valueOf((char)('A'+(prefix-10)));
        }

    }
}
