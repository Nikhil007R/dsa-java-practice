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

class TopView {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static class Pair{

        int order;
        Node node;

        Pair(Node node, int order){
            this.node = node;
            this.order = order;
        }
    }

    public static void topView(Node root) {

        if(root == null) return ;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){

            Pair pair = q.poll();
            int order = pair.order;
            Node temp = pair.node;

            if(!map.containsKey(order)){
                map.put(order, temp.data);
            }
            if(temp.left != null){
                q.offer(new Pair(temp.left, order-1));
            }
            if(temp.right != null){
                q.offer(new Pair(temp.right, order+1));
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getValue() + " ");
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
        topView(root);
    }
}
