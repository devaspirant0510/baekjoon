import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> pokemonDictionary = new HashMap<>();
        HashMap<Integer, String> pokemonDictionaryNumber = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            pokemonDictionary.put(pokemonName, i);
            pokemonDictionaryNumber.put(i, pokemonName);
        }
        for (int i = 0; i < M; i++) {
            String userInput = br.readLine();
            try{
                int num = Integer.parseInt(userInput);
                System.out.println(pokemonDictionaryNumber.get(num));
            }catch (NumberFormatException e){
                System.out.println(pokemonDictionary.get(userInput));

            }

        }
    }
}
