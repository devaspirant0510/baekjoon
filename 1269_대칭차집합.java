import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int el = Integer.parseInt(st.nextToken());
            setA.add(el);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int el = Integer.parseInt(st.nextToken());
            setB.add(el);
        }
        Object[] setAArray =  setA.toArray();
        Object[] setBArray =  setB.toArray();
        for (int i = 0; i < b; i++) {
            if(setA.contains(setBArray[i])){
                setA.remove(setBArray[i]);
            }
        }
        for (int i = 0; i < a; i++) {
            if(setB.contains(setAArray[i])){
                setB.remove(setAArray[i]);
            }
        }
        System.out.println(setA.size()+setB.size());
    }
}
