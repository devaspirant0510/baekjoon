import java.util.*;

public class Main {
    static class Print {
        private int position; // 문서의 위치
        private int value;    // 문서의 중요도

        public Print(int position, int value) {
            this.position = position;
            this.value = value;
        }

        public int getPosition() {
            return position;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // 테스트 케이스 수
        List<Integer> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt(); // 문서 개수
            int m = scanner.nextInt(); // 목표 문서의 위치

            // 문서 정보를 큐에 저장
            Queue<Print> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                queue.add(new Print(i, priority));
            }

            int printOrder = 0; // 출력 순서

            while (!queue.isEmpty()) {
                Print current = queue.poll(); // 큐의 가장 앞 문서

                // 현재 문서보다 중요도가 높은 문서가 있는지 확인
                boolean hasHigherPriority = queue.stream()
                        .anyMatch(doc -> doc.getValue() > current.getValue());

                if (hasHigherPriority) {
                    // 중요도가 더 높은 문서가 있으면 현재 문서를 뒤로 보냄
                    queue.add(current);
                } else {
                    // 현재 문서를 인쇄
                    printOrder++;
                    if (current.getPosition() == m) {
                        // 목표 문서가 인쇄된 경우
                        results.add(printOrder);
                        break;
                    }
                }
            }
        }

        // 결과 출력
        results.forEach(System.out::println);
    }
}

