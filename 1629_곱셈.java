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
 * 📌 문제 번호  : 1629
 * 📌 문제 제목  : 곱셈
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/1629
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-05-05
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        System.out.println(func(a,b,c));



    }
    private static long func(int a,int b,int c){
        if(b==1){
            return a%c;
        }
        long val =  func(a,b/2,c);
        val = val*val%c;
        if(b%2==0){
            return val;
        }
        return val*a%c;

    }
}

