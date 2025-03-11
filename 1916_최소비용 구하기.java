/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 1916
 * 📌 문제 제목  : 최소비용 구하기
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/1916
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-03-10
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    protected static ArrayList<ArrayList<Node>> graph;
    protected static int[] dist;
    protected static boolean[] visited;
    protected static PriorityQueue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }
        dist = new int[n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(a - 1).add(new Node(weight, b - 1));
        }
        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        queue = new PriorityQueue<>();
        queue.add(new Node(0, start - 1));
        Arrays.fill(dist,2134000000);
        dijkstra(start - 1);
        System.out.println(dist[end-1]);
    }

    protected static void dijkstra(int start) {
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node getNode = queue.remove();
            if (visited[getNode.index]) continue;
            visited[getNode.index] = true;
            if (getNode.getWeight() > dist[getNode.index]) {
                continue;
            }
            for (Node node : graph.get(getNode.index)) {
                if (dist[node.index] > dist[getNode.index] + node.weight) {
                    queue.add(new Node(dist[getNode.index] + node.weight, node.index));
                    dist[node.index] = dist[getNode.index] + node.weight;
                }
            }

        }


    }


    public static class Node implements Comparable<Node> {
        private Integer weight;
        private Integer index;

        public Node(Integer weight, Integer index) {
            this.weight = weight;
            this.index = index;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", index=" + index +
                    '}';
        }
    }
}
