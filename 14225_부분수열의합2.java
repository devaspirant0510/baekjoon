import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Long> sumList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        combination(arr, new ArrayList<Long>(), 0, 0, n);
        sumList.add(0L);
        ArrayList<Long> unique = new ArrayList<>(new HashSet<Long>(sumList));
        Collections.sort(unique);
        for (int i = 0; i < unique.size()-1; i++) {
            if (unique.get(i) + 1 == unique.get(i + 1)) {
                continue;
            }
            System.out.println(unique.get(i) + 1);
            return;

        }
        System.out.println(unique.get(unique.size()-1)+1);
    }

    protected static void combination(long[] arr, List<Long> output, int index, int outputSize, int n) {
        if(!output.isEmpty()){
            long sum = 0;
            for (long el:output){
                sum+=el;
            }
            sumList.add(sum);
        }
        for (int i = index; i < n; i++) {
            output.add(arr[i]);
            combination(arr, output, i + 1, outputSize, n);
            output.remove(output.size() - 1);

        }
    }

}
