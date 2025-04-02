/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 1918
 * 📌 문제 제목  : 후위 표기식
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/1918
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-01
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        List<Character> output = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            /**
             * 1. 피연산자는 그대로 출력합니다.
             * 2. 연산자는 스택이 비어있으면 자신을 바로 추가합니다.
             * 3. stack의 top이 자신보다 우선순위가 낮은 연산자를 만날 때까지 pop 하고 자신을 담습니다.
             * 4. 단, 여는 괄호는 닫는 괄호가 아니면 pop하지 않습니다.
             * 4. 닫는 괄호가 나오면 여는 괄호가 나올 때까지 꺼내서 출력합니다.
             * 5. 마지막에 도착하면 스택에서 차례로 꺼내서 출력합니다.
             */
            /**
             * 1. 피연산자는 그대로
             * 2. * / 이 연산의 우선순위: 스택에 들어가면 바로 팝 + - 가 나올떄까지 팝
             * 3. + - 이건 연산 후순위 : 스택 탑이 뭐든간에 일단 팝해서 아웃풋에넣고 추가
             * 4. ( 일단 푸시
             * 4. ) ( 나올때까지  팝
             */
            char citem = input.charAt(i);
            // 알파벳은 걍 추가
            if ('A' <= citem && citem <= 'Z') {
                output.add(citem);
            } else {
                // 여는 괄호도 일단 추가
                if (citem == '(') {
                    stack.add(citem);
                }
                // 닫는 괄호는 여는 괄호가 나올때까지 팝해서 출력 큐에 넣기
                else if (citem == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.add(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }

                }
                if (isFirstPriority(citem)) { // 스택 탑에 곱나 있으면 먼저 꺼냄
                    while (!stack.isEmpty() && isFirstPriority(stack.peek())) {
                        output.add(stack.pop());
                    }
                    stack.push(citem);
                }
                else if (isLastPriority(citem)) {
                    // 덧셈뺄셈은 후순위 곱나 있으면 곱나 먼저 처리하고 덧뺌 있으면 먼저온애 먼저 처리
                    while (!stack.isEmpty() && stack.peek() != '(' && (isFirstPriority(stack.peek()) || isLastPriority(stack.peek()))) {
                        output.add(stack.pop());
                    }
                    stack.push(citem);
                }
            }


        }
        // 남아있는거 다추가
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        output.forEach(System.out::print);

    }


    private static boolean isOpen(char sign) {
        return sign == '(';
    }

    private static boolean isClose(char sign) {
        return sign == ')';
    }

    protected static boolean isFirstPriority(char sign) {
        return sign == '*' || sign == '/';
    }

    protected static boolean isLastPriority(char sign) {
        return sign == '+' || sign == '-';
    }
}
