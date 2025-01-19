import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short a = Short.parseShort(br.readLine());
        short b = Short.parseShort(br.readLine());
        System.out.println(a*b);
    }
}