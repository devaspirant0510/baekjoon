/*============================================================================
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*@@@@@@@@@@@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@$ .@@@@@@@@@@@@@@@@@@@@@@@@@@**@@@@@@@@@@@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@@@@@@*!@@@@@@@@@@@@@@@
 @@@@@@@@@@  .@@=.      ~: .@@@@@@@@@@@@@@@@@@@@@@@@@! !@@@@@@@@@@@@@@@
 @@@@@@@@@:    ,           *@@@@@@@@@@@@@@@@@@@@@@#@@! ,@!:@@@@@@@@@@@@
 @@@@@@@@@= .~              ~@@@@@@@@@@@@@@@@@@@@#  @  .*  !**=@@@@@@@@
 @@@@@@@@@@~       *,-!      = :@@@@@@@@@@@@@@@@@=  ! *,.  !   ;@@@@@@@
 @@@@@@@@@@@$.         .    ~    @@@@@@@@@@@@@@@@@ ; -:    ,    =@@@@@@
 @@@@@@@@@@@=    .      :   ~     @@@@@@@@@@@@@@@@, ;     !,    *@@@@@@
 @@@@@@@@@@@;   ,           ~    :#@@@@@@@@@@@@!   -!.    ~  -;.@@@@@
 @@@@@@@@@@@,   *  *     ;  ~   .**@@@@@@@@@@@@# . ~  *. ~   * .  ~@@@@
 @@@@@@@@@@@,   !  *-    :       ,!@@@@@@@@@@@@  ;  ! *  :   .     @@@@
 @@@@@@@@@@@,   *  **    :        *@@@@@@@@@@@-   ,  , :;     ,   ,@@@@
 @@@@@@@@@@@;   .        !   :    @@@@@@@@@@@!                ! . #@@@@
 @@@@@@@@@@@=              **     @@@@@@@@@@@   !             !!*,*@@@@
 @@@@@@@@@@@@    .      : .,. !  @@@@@@@@@@@*   !    .        !    !@@@
 @@@@@@@@@@@@     ,    .  !,*   @@@@@@@@@@@@.        *        *     @@@
 @@@@@@@@@@@@.      ~!-   .     @@@@@@@@@@@@                  *    ~@@@
 @@@@@@@@@@@@;                  @@@@@@@@@@@@   !;**   .       * -! @@@@
 @@@@@@@@@@@@!                  @@@@@@@@@  :       ..!        ! -!@@@@@
 @@@@@@@@@@@@~                  @@@@@@@@*   !   !   !         !  =#**@@
 @@@@@@@@@@@@:~~:-----~~~:~~~~~~#@@@@@@@!        .;,          ! !,  .@@
 @@@@@@@@@@@!:::::-            .@@@@@@@@=    ,                :!  ;*=@@
 @@@@@@@@@@@:::::.             .@@@@@@@@@!     !.    -;        ;    =@@
 @@@@@@@@@@:::::.        !: -  ;@@@@@@#@@@#-      *.            ! !@@@@
 @@@@@@@@@:::::    .    .*:-   =@@@@@@@@*@@@!     : .~~.         *@@@@@
 @@@@@@@@:::::,    ;.    !: :  ;@@@@@@@#@@@#@#-   .,,-~ .  -      ;==@@
 @@@@@@@;::::.      !  ! !; :! ~@@@@@@@@@$=@@@@@*~..,  .,   ~       -!!
 @@@@@@;::::;         .: ! :: .@@@@@@@@@*@@@@@@@@@...  ..     ;
 @@@@;::::;;;         ;: * :  =@@@@@@@@@@@@@@@@@@@~,,.,-.      :,    -:
 @#::::;;;;;;-         ;  :!  @@@@@@@@@@@@@@@@@@@@* ,..,         ,  ,~*
 @:=!;;;;;;;;*            :  =@@@@@@@@@@@@@@@@@@@@@              ~,*~=@
 *@@@@@!;;;;;;.         ;;  ~@@@@@@@@@@@@@@@@@@@@@@$              @@@@@
 @@@@@@@@@##@@@            ,@@@@@@@@@@@@@@@@@@@@@@@@=             @@@@@
 @@@@@@@@@@@@@@@! .       !@@@@@@@@@@@@@@@@@@@@@@@@@@=  !,       !@@@@@
 @@@@@@@@@@@@@@@@#.,   -*@.@@@@@@@@@@@@@@@@@@@@@@@@@@*    @$     =@@@@@
 @@@@@@@@@@@@@@@@:@@@@@@=@@@@@@@@@@@@@@@@@@@@@@@@@@*    @$     @@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*    @*    ;@@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@;    @:    @@@@@@@
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.   !@.   ~@@@@@@@
 * ──────────────────────────────────────────────────────────────────────────
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 4179
 * 📌 문제 제목  : 불!
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/4179
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-05-05
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
5 4
####
#JF#
#..#
#..#
....
4 4
####
.JF#
#FF#
#..#
 */
public class Main {
    // 벽 : -1  불 : -2  지훈 : -3  길 : 0
    private static final int FIRE = -2;
    private static final int WALL = -1;
    private static final int JI = -3;
    private static final int ROAD = 0;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        int[][] arr = new int[r][c];
        boolean[][] jCache = new boolean[r][c];
        int[][] fireTime = new int[r][c];
        for (int[] row : fireTime) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> jQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                int value = convertValue(row.charAt(j));
                // 불
                if (value == FIRE) {
                    fQueue.add(new int[]{i, j, 0});
                    fireTime[i][j] = 0;
                } else if (value == JI) {
                    jQueue.add(new int[]{i, j, 0});
                    jCache[i][j] = true;
                }
                arr[i][j] = value;
            }
        }
        // 벽 : -1  불 : -2  지훈 : -3  길 : 0
        // 1. 불이 퍼지는 시간 기록
        while (!fQueue.isEmpty()) {
            int[] pos = fQueue.poll();
            int y = pos[0], x = pos[1], time = pos[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isGo(ny, nx) && arr[ny][nx] != WALL && fireTime[ny][nx] == Integer.MAX_VALUE) {
                    fireTime[ny][nx] = time + 1;
                    fQueue.add(new int[]{ny, nx, time + 1});
                }
            }
        }

        while (!jQueue.isEmpty()) {
            int[] pos = jQueue.poll();
            int y = pos[0], x = pos[1], time = pos[2];

            // 탈출 조건: 가장자리에 있고 다음 스텝으로 미로를 벗어날 수 있는 경우
            if (y == 0 || x == 0 || y == r - 1 || x == c - 1) {
                System.out.println(time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isGo(ny, nx) && !jCache[ny][nx] && arr[ny][nx] != WALL) {
                    // 불보다 먼저 도착할 수 있을 때만 이동
                    if (fireTime[ny][nx] > time + 1) {
                        jCache[ny][nx] = true;
                        jQueue.add(new int[]{ny, nx, time + 1});
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean isGo(int goY, int goX) {
        return 0 <= goY && goY < r && 0 <= goX && goX < c;
    }

    private static int convertValue(char a) {
        // 벽 : -1  불 : -2  지훈 : -3  길 : 0
        if (a == '#') {
            return -1;
        } else if (a == 'F') {
            return -2;
        } else if (a == 'J') {
            return -3;
        } else {
            return 0;
        }
    }
}