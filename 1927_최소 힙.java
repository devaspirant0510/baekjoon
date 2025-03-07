import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(br.readLine());
            if(el==0){
                if(priorityQueue.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(priorityQueue.remove()+"\n");
                }
            }else{
                priorityQueue.add(el);
            }
        }
        bw.flush();
        bw.close();

    }
}