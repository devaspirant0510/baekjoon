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
 * 📌 문제 번호  : 15683
 * 📌 문제 제목  : 감시
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/15683
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-05-07
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;

    // 1번 한방향
    // 2번 양방향
    // 3번 직각방향
    // 4번 세방향
    // 5번 네방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        int[][] arr = new int[n][m];
        boolean[][] cached = new boolean[n][m];
        StringTokenizer st;
        List<int[]> q = new ArrayList<>();
        // 5번시시티비는 방향전환이 없기떄문에 사전에 처리
        List<int[]> q5 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (1 <= value && value < 5) {
                    // cctv 있는곳은 이미 비춰지는곳
                    cached[i][j] = true;
                    //0 위 1 우 2 하 3 좌
                    q.add(new int[]{i, j, value, 0});

                }
                if(value==5){
                    q5.add(new int[]{i,j,value,0});
                }
                // 벽은 시시티비가 감시자체를 못하니 방문처리
                if (value == 6) {
                   cached[i][j] = true;
                }
                arr[i][j] = value;
            }
        }
        List<Integer> cctvRange = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            // cctv 5번 유형은 항상 고정이어서 나머지는
            int[] getCctvInfo = q.get(i);
            if (getCctvInfo[2] != 5) {
                if (getCctvInfo[2] == 2) {
                    // 2번 cctv 는 방향전환이 2개
                    cctvRange.add(2);
                } else {
                    // 나머지는 방향전환 4개
                    cctvRange.add(4);
                }
            }
        }
        for (int i = 0; i <q5.size() ; i++) {
            int[] getCctvInfo = q5.get(i);
            for (int x = getCctvInfo[1]; x < m; x++) {
                // 벽만나면 방문처리 끝
                if (arr[getCctvInfo[0]][x] == 6) {
                    break;
                }
                cached[getCctvInfo[0]][x] = true;
            }
            for (int x = getCctvInfo[1]; x >= 0; x--) {
                // 벽만나면 방문처리 끝
                if (arr[getCctvInfo[0]][x] == 6) {
                    break;
                }
                cached[getCctvInfo[0]][x] = true;
            }
            for (int y = getCctvInfo[0]; y < n; y++) {
                // 벽만나면 방문처리 끝
                if (arr[y][getCctvInfo[1]] == 6) {
                    break;
                }
                cached[y][getCctvInfo[1]] = true;
            }
            for (int y = getCctvInfo[0]; y >= 0; y--) {
                // 벽만나면 방문처리 끝
                if (arr[y][getCctvInfo[1]] == 6) {
                    break;
                }
                cached[y][getCctvInfo[1]] = true;
            }

        }

        List<int[]> status = new ArrayList<>();

        getAllCctv(0, new int[cctvRange.size()], cctvRange.size(), cctvRange, status);



        int maxViewCount = n*m+1;
        for (int i = 0; i < status.size(); i++) {
            boolean[][] backupCache = copy2DArray(cached);
            for (int j = 0; j < q.size(); j++) {
                int[] cctvInfo = q.get(j);
                int cctv = cctvInfo[2];
                int[] cctvDir = status.get(i);
                // 5번 시시티비 이미 했으니까 패스
                if (cctv != 5) {
                    // 직선 cctv

                        viewCctv(cctv, cctvInfo[0], cctvInfo[1], cctvDir[j], backupCache, arr);


                }
            }
//            for(int e:status.get(i)){
//                System.out.print(e+",");
//            }
//            System.out.println();
//            showCache(backupCache);
//            System.out.println();
            int cc = getAbleViewCount(backupCache);
            if(maxViewCount>cc){
                maxViewCount = cc;
            }


        }
        System.out.println(maxViewCount);
    }

    public static int getAbleViewCount(boolean[][] cached) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!cached[i][j]) {
                    c++;
                }
            }
        }
        return c;
    }

    public static void showCache(boolean[][] cached) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cached[i][j]?"🟦":"⬜️" + "");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void viewTop(int y, int x, int[][] arr, boolean[][] cached) {
        for (int i = y; i >= 0; i--) {
            if (arr[i][x] == 6) {
                break;
            }
            cached[i][x] = true;
        }

    }

    public static void viewRight(int y, int x, int[][] arr, boolean[][] cached) {
        for (int i = x; i < m; i++) {
            if (arr[y][i] == 6) {
                break;
            }
            cached[y][i] = true;
        }

    }

    public static void viewBot(int y, int x, int[][] arr, boolean[][] cached) {
        for (int i = y; i < n; i++) {
            if (arr[i][x] == 6) {
                break;
            }
            cached[i][x] = true;
        }
    }

    public static void viewLeft(int y, int x, int[][] arr, boolean[][] cached) {
        for (int i = x; i >= 0; i--) {
            if (arr[y][i] == 6) {
                break;
            }
            cached[y][i] = true;
        }
    }

    public static void viewCctv(int cctvType, int y, int x, int dir, boolean[][] cached, int[][] arr) {
        switch (cctvType) {
            // 일자 씨씨티비
            case 1: {
                /// 위
                if (dir == 0) {
                    viewTop(y, x, arr, cached);
                }
                // 우
                else if (dir == 1) {
                    viewRight(y, x, arr, cached);
                }
                // 하
                else if (dir == 2) {
                    viewBot(y, x, arr, cached);
                }
                // 좌
                else {
                    viewLeft(y, x, arr, cached);
                }
                break;
            }
            // 양방향 일자 씨시티비
            case 2:{
                if(dir==0){
                    viewTop(y, x, arr, cached);
                    viewBot(y, x, arr, cached);
                }
                else{
                    viewRight(y, x, arr, cached);
                    viewLeft(y, x, arr, cached);
                }
                break;
            }
            // 기역자 시시티비
            case 3:{
                if(dir==0){
                    viewTop(y, x, arr, cached);
                    viewRight(y, x, arr, cached);
                }
                else if(dir==1){
                    viewRight(y, x, arr, cached);
                    viewBot(y, x, arr, cached);
                }
                else if(dir==2){
                    viewBot(y, x, arr, cached);
                    viewLeft(y, x, arr, cached);
                }else{
                    viewLeft(y, x, arr, cached);
                    viewTop(y, x, arr, cached);
                }
                break;
            }
            // 3방향 씨시티비
            case 4:{
                if(dir==0){
                    // ㅏ
                    viewTop(y, x, arr, cached);
                    viewRight(y, x, arr, cached);
                    viewBot(y, x, arr, cached);
                }
                else if(dir==1){
                    // ㅜ
                    viewRight(y, x, arr, cached);
                    viewBot(y, x, arr, cached);
                    viewLeft(y, x, arr, cached);
                }
                else if(dir==2){
                    // ㅓ
                    viewBot(y, x, arr, cached);
                    viewLeft(y, x, arr, cached);
                    viewTop(y, x, arr, cached);
                }else{
                    // ㅗ
                    viewLeft(y, x, arr, cached);
                    viewTop(y, x, arr, cached);
                    viewRight(y, x, arr, cached);
                }
                break;
            }

        }

    }

    public static boolean[][] copy2DArray(boolean[][] src) {
        boolean[][] dest = new boolean[src.length][];
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i].clone(); // 얕은 복사 방지
        }
        return dest;
    }

    public static int[][] copy2DArray(int[][] src) {
        int[][] dest = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i].clone(); // 얕은 복사 방지
        }
        return dest;
    }

    private static void getAllCctv(int depth, int[] cctvDir, int n, List<Integer> cctvRange, List<int[]> status) {
        if (depth == n) {
            status.add(Arrays.copyOf(cctvDir, cctvDir.length));
            return;
        }
        for (int dir = 0; dir < cctvRange.get(depth); dir++) {
            cctvDir[depth] = dir;
            getAllCctv(depth + 1, cctvDir, n, cctvRange, status);
        }
    }
}

