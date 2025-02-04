import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 4 5 1 3 2
// sad

// 5 4 1 3 2
// nice

// 1 2 3 4 5
// nice

// 5 4 3 2 1
// nice

// 1 5 3 4 2
// sad

// 1 3 2 4
// nice
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int c = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> currentQueue = new LinkedList<>();
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            currentQueue.add(Integer.parseInt(st.nextToken()));
        }
        while (!currentQueue.isEmpty()) {
            int getCur = currentQueue.poll();
            // 임시 스택에 팝을 했는데 다음사람의 번호표인지 체크
            while (!tempStack.isEmpty()) {
                if (c + 1 == tempStack.peek()) {
                    c++;
                    tempStack.pop();
                } else {
                    break;
                }
            }

            // 대기열에서 뺀 사람의 번호표가 순서대로 되어있다면
            if (getCur == c + 1) {
                c++;
            } else {
                tempStack.push(getCur);
            }
        }


        while (!tempStack.isEmpty()) {
            if (c + 1 == tempStack.peek()) {
                c++;
                tempStack.pop();
            } else {
                break;
            }
        }
        System.out.println(tempStack.isEmpty() ? "Nice" : "Sad");

    }

}
