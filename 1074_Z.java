import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = z(n,r,c);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
    protected static int z(int n,int r,int c){
        if(n==0){
            return 0;
        }
        return 2*(r%2)+(c%2)+4*z(n-1,r/2,c/2);
    }
}