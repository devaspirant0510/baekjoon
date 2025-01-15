import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 보드 크기 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        // 보드 상태 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        // 두 가지 체스판을 만들기 위한 색깔 규칙
        // 첫 번째 체스판(왼쪽 상단이 'W')과 두 번째 체스판(왼쪽 상단이 'B')을 비교
        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 각 8x8 영역에 대해 비교
                minChanges = Math.min(minChanges, getMinChanges(board, i, j));
            }
        }

        // 최소 변경 횟수 출력
        System.out.println(minChanges);
    }

    // 8x8 부분 보드에서 바뀐 칸의 수 계산
    public static int getMinChanges(char[][] board, int startX, int startY) {
        int changesForFirstBoard = 0;
        int changesForSecondBoard = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColorForFirstBoard = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedColorForSecondBoard = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[startX + i][startY + j] != expectedColorForFirstBoard) {
                    changesForFirstBoard++;
                }
                if (board[startX + i][startY + j] != expectedColorForSecondBoard) {
                    changesForSecondBoard++;
                }
            }
        }

        // 두 체스판 중 더 적은 바뀐 칸 수 반환
        return Math.min(changesForFirstBoard, changesForSecondBoard);
    }
}
