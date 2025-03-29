/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 11003
 * 📌 문제 제목  : 최솟값 찾기
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/11003
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-28
 ============================================================================*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int index;
        int node;

        public Node(int index, int node) {
            this.index = index;
            this.node = node;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line =br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int l = Integer.parseInt(line[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int insert = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().node>insert){
                deque.removeLast();
            }
            deque.addLast(new Node(i,insert));
            if(deque.getFirst().index <= i-l){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().node+" ");

        }
        bw.flush();
        bw.close();
    }
}
