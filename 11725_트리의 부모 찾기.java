/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 11725
 * 📌 문제 제목  : 트리의 부모 찾기
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/11725
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-30
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int[] result;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int left = Integer.parseInt(line[0]);
            int right = Integer.parseInt(line[1]);

            tree.get(left).add(right);
            tree.get(right).add(left);
        }

        dfs(1);  // 루트 노드부터 DFS 실행

        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int parent) {
        visited[parent] = true;
        for (int child : tree.get(parent)) {
            if (!visited[child]) {
                result[child] = parent;
                dfs(child);
            }
        }
    }
}
