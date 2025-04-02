/*============================================================================
 * 🏆 백준 온라인 저지 (Baekjoon Online Judge)
 * ──────────────────────────────────────────────────────────────────────────
 * 📌 문제 번호  : 5639
 * 📌 문제 제목  : 이진 검색 트리
 * 🔗 문제 링크  : https://www.acmicpc.net/problem/5639
 * ✏️ 작성자     : seungho0510
 * 📅 작성 날짜  : 2025-04-03
 ============================================================================*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static class Node{
        public Node(int value) {
            this.value = value;
        }

        int value;

        Node left;
        Node right;
    }
    private static class Tree{
        Node root;

        public Tree() {
        }

        public Tree(Node root) {
            this.root = root;
        }
        void lrv(Node node){
            if(node!=null){
                lrv(node.left);
                lrv(node.right);
                System.out.println(node.value);
            }

        }

        void showDefaultTree(){
            if (root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();  // 현재 레벨의 노드 개수
                for (int i = 0; i < levelSize; i++) {
                    Node current = queue.poll();
                    System.out.print(current.value + " ");

                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }
                System.out.println(); // 줄 바꿈 (층 구분)
            }
        }
        void insert(Node root,Node node){
            if(root.value==node.value){
                return;
            }
            // 좌측으로
            else if(node.value<root.value){
                if(root.left==null){
                    root.left = node;
                    return;
                }
                insert(root.left,node);
            }
            else {
                if(root.right==null){
                    root.right = node;
                    return;
                }
                insert(root.right,node);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        int i =0;
        while(true){
            String str = br.readLine();

            if(str == null || str.equals("")) break;
            if (i==0){
                tree.root = new Node(Integer.parseInt(str));
            }else{
                tree.insert(tree.root,new Node(Integer.parseInt(str)));
            }
            i++;

        }
        tree.lrv(tree.root);

    }
}
