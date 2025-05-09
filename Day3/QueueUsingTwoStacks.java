package Day3;

import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> stackNewest = new Stack<>();
        Stack<Integer> stackOldest = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1: // Enqueue
                    int x = sc.nextInt();
                    stackNewest.push(x);
                    break;

                case 2: // Dequeue
                    if (stackOldest.isEmpty()) {
                        while (!stackNewest.isEmpty()) {
                            stackOldest.push(stackNewest.pop());
                        }
                    }
                    if (!stackOldest.isEmpty()) {
                        stackOldest.pop();
                    }
                    break;

                case 3: // Print front
                    if (stackOldest.isEmpty()) {
                        while (!stackNewest.isEmpty()) {
                            stackOldest.push(stackNewest.pop());
                        }
                    }
                    if (!stackOldest.isEmpty()) {
                        System.out.println(stackOldest.peek());
                    }
                    break;
            }
        }
        sc.close();
    }
}
