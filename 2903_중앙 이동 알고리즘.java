import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 규칙 : 한변의 칸의 개수는 2배씩 증가 점의 개수의 제곱으로 구하면 가능 점의개수는 칸개수+1
        // 0=4 한 변의 칸 1
        // 1=9 한 변의 칸 2
        // 2=25 한 변의 칸 4
        // 3=81 한 변의 칸 8
        // ...
        // (2^N+1)**2
        int result = (int) (Math.pow(2,N)+1);
        System.out.println(result*result);
        bw.flush();
        bw.close();

    }
}