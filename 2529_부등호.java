import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited ;
    static String[] oc;
    static  int[] output ;
    static StringBuilder sb;
    static long maxV=-1;
    static String maxS;
    static long minV=10000000000L;
    static String minS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        oc = new String[n];
        visited = new boolean[10];
        output = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            oc[i] = st.nextToken();
        }
        arr[n] = arr[n-1]+1;

        npr(arr,0,10,n+1);
        System.out.println(maxS);
        System.out.println(minS);

    }
    public static void npr(int[] arr,int depth,int n,int r){
        if(depth==r){
            int i;
            sb = new StringBuilder();
            for ( i = 0; i < r-1; i++) {

                if(oc[i].equals("<")){
                    if(output[i]>output[i+1]){
                        break;
                    }
                    sb.append(output[i]);
                }else{
                    if(output[i]<output[i+1]){
                        break;
                    }
                    sb.append(output[i]);
                }
            }
            sb.append(output[r-1]);
            if(i==r-1){
                long convertV = Long.parseLong(sb.toString());
                if(convertV>maxV){
                    maxV = convertV;
                    maxS = sb.toString();
                }
                if(convertV<minV){
                    minV = convertV;
                    minS = sb.toString();
                }

            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                output[depth] = arr[i];
                npr(arr,depth+1,n,r);
                visited[i] = false;
            }
        }
    }
}
