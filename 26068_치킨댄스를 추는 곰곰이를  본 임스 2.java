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
 * 📌 문제 번호  : 26068
 * 📌 문제 제목  : 치킨댄스를 추는 곰곰이를 본 임스 2
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/26068
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-16
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int days = Integer.parseInt(br.readLine().split("-")[1]);
            if(days<=90){
                count++;

            }
        }
        System.out.println(count);
    }
}

