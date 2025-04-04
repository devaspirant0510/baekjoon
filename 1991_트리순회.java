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
 * 📌 문제 번호  : 1991
 * 📌 문제 제목  : 트리 순회
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/1991
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-03
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader 비알 = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(비알.readLine());
        노드[] 노드사전 = new 노드[26];
        트리 이진트리 = new 트리();
        // 첫줄은 루트
        // A 는 루트 항상 고정이니 A 노드  만들기
        String[] 한줄;
        for (int i = 0; i < N ; i++) {
            한줄 = 비알.readLine().split(" ");
            // 노드가 만들어 졌는지 확인
            이진트리.트리만들기(한줄[0].charAt(0), 한줄[1].charAt(0), 한줄[2].charAt(0));


        }
        이진트리.전위순회(이진트리.루트);
        System.out.println();
        이진트리.중위순회(이진트리.루트);
        System.out.println();
        이진트리.후위순회(이진트리.루트);


    }

    protected static class 트리 {
        노드[] 노드사전 = new 노드[26];
        private 노드 루트;

        public void 루트노드설정(노드 루트) {
            this.루트 = 루트;
        }

        public void 전위순회(노드 루트) {
            if (루트 != null) {
                System.out.print(루트.값);
                전위순회(루트.좌);
                전위순회(루트.우);
            }
        }

        public void 중위순회(노드 루트) {
            if (루트 != null) {
                중위순회(루트.좌);
                System.out.print(루트.값);
                중위순회(루트.우);
            }
        }

        public void 후위순회(노드 루트) {
            if (루트 != null) {
                후위순회(루트.좌);
                후위순회(루트.우);
                System.out.print(루트.값);
            }
        }

        private boolean isRoot() {
            for (노드 node : 노드사전) {
                if (node != null) {
                    return false;
                }
            }
            return true;
        }

        public void 트리만들기(char 루트값, char 좌, char 우) {
            int 루트사전번호 = 루트값 - 65;
            int 루트좌번호 = 좌 - 65;
            int 루트우번호 = 우 - 65;
            노드 룻노드;
            if (노드사전[루트사전번호] == null) {
                룻노드 = new 노드(루트값);
                if (isRoot()) {
                    루트 = 룻노드;
                }
                노드사전[루트사전번호] = 룻노드;
            } else {
                룻노드 = 노드사전[루트사전번호];
            }
            if (좌 == '.') {
                룻노드.좌 = null;
            }
            if (우 == '.') {

                룻노드.우 = null;

            }
            if (좌 != '.') {
                if (노드사전[루트좌번호] == null) {
                    노드 좌파노드 = new 노드(좌);
                    노드사전[루트좌번호] = 좌파노드;
                    룻노드.좌 = 좌파노드;

                } else {
                    룻노드.좌 = 노드사전[루트좌번호];
                }
            }
            if (우 != '.')
                if (노드사전[루트우번호] == null) {
                    노드 우파노드 = new 노드(우);
                    노드사전[루트우번호] = 우파노드;
                    룻노드.우 = 우파노드;

                } else {
                    룻노드.우 = 노드사전[루트우번호];
                }
        }
    }

    protected static class 노드 {
        char 값;
        노드 좌;
        노드 우;

        public 노드(char 값) {
            this.값 = 값;
        }
    }
}
