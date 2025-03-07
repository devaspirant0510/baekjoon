import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();
            if(prompt.equals("all")){
                set.clear();
                set.addAll(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
            }
            else if(prompt.equals("empty")){
                set.clear();
            }
            else if(prompt.equals("add")){
                int el = Integer.parseInt(st.nextToken());
                set.add(el);
            }
            else if(prompt.equals("remove")){
                int el = Integer.parseInt(st.nextToken());
                set.remove(el);
            }
            else if(prompt.equals("check")){
                int el = Integer.parseInt(st.nextToken());
                bw.write((set.contains(el)?1:0)+"\n");
            }
            else if(prompt.equals("toggle")){
                int el = Integer.parseInt(st.nextToken());
                if(set.contains(el)){
                    set.remove(el);
                }else{
                    set.add(el);
                }
            }


        }
        bw.flush();
        bw.close();

    }
}