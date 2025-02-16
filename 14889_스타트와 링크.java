import java.io.*;
import java.util.*;

public class Main {
    // 매칭시킬 수 있는 팀의 조합 리스트
    static List<int[]> teamMatches;
    static int[][] userTable;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        teamMatches = new ArrayList<>();
        userTable = new int[n][n];
        int[] teams = new int[n];

        for (int i = 0; i < n; i++) {
            teams[i] = i + 1;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int el = Integer.parseInt(st.nextToken());
                userTable[i][j] = el;
            }
        }

        // nCr 로 대진표 조합
        ncr(teams, new int[n / 2], 0, 0, n, n / 2);
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < teamMatches.size() / 2; i++) {

            // 양끝에서부터 가운데로 오면서 각 팀의 파워 차이 구함
            /**
             * 6C3 일경우
             * 1,2,3
             * 1,2,4
             * ...
             * 3,5,6
             * 4,5,6
             * 양끝단에서 가운데로 모이면서 양팀에 균등하게 분배됨
             */
            int[] startTeamLineUp = teamMatches.get(i);
            int[] linkTeamLineUp = teamMatches.get(teamMatches.size() - i - 1);

            int s = calcPower(startTeamLineUp);
            int l = calcPower(linkTeamLineUp);

            int value = Math.abs(s - l);
            if (value == 0) {
                // 빠른 퇴근
                System.out.println(0);
                return;
            }
            if (minValue > value) {
                minValue = value;
            }
        }
        System.out.println(minValue);
    }

    protected static int calcPower(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += userTable[arr[i] - 1][arr[j] - 1];
                sum += userTable[arr[j] - 1][arr[i] - 1];
            }
        }
        return sum;
    }

    // nCr 조합 생성
    public static void ncr(int[] arr, int[] output, int depth, int start, int n, int r) {
        if (depth == r) {
            // 조합 결과를 리스트에 넣음
            teamMatches.add(Arrays.copyOf(output, r));
            return;
        }
        for (int i = start; i < n; i++) {
            output[depth] = arr[i];
            ncr(arr, output, depth + 1, i + 1, n, r);
        }
    }
}
