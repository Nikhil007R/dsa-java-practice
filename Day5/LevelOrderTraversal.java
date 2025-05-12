package Day5;

import java.util.*;
        import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrderTraversal {

    /* 
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {

        Queue<Node> que = new LinkedList<>();
        if(root == null) return ;

        que.offer(root);

        while(!que.isEmpty()){
            int queSize = que.size();
            for(int i=0; i<queSize; i++){
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);
                System.out.print(que.poll().data + " ");
            }
        }


    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
