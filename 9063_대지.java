import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        int maxX=-15818,maxY = -15818;
        int minX=77744,minY = 77744;


        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x>maxX){
                maxX = x;
            }
            if(y>maxY){
                maxY= y;
            }
            if(x<minX){
                minX = x;
            }
            if(y<minY){
                minY = y;
            }
        }
        System.out.println((maxY-minY)*(maxX-minX));

    }
}