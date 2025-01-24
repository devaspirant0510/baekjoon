import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<String, Boolean> userLog = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean log = st.nextToken().equals("enter");
            if(!log){
                userLog.remove(name);
            }else{
                userLog.put(name,log);
            }
        }
        Object[] array = userLog.keySet().toArray();
        Arrays.sort(array);
        for (int i = array.length-1; i>=0; i--) {
            System.out.println(array[i]);

        }
    }
}
