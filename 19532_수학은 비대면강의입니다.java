import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                // 무식하게 하나하나 다 넣는 방식
                if(x1*x+y1*y==r1 && x2*x+y2*y==r2){
                    System.out.println(x+" "+y);



                }


            }

        }
    }

}