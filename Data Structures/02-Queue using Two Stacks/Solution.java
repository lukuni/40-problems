import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt(); // Number of queries
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            
            switch(queryType) {
                case 1:
                    // Enqueue element
                    int x = sc.nextInt();
                    stack1.push(x);
                    break;
                case 2:
                    // Dequeue element
                    if (stack2.isEmpty()) {
                        // Move all from stack1 to stack2
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                    break;
                case 3:
                    // Print front element
                    if (stack2.isEmpty()) {
                        // Move all from stack1 to stack2
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        System.out.println(stack2.peek());
                    }
                    break;
            }
        }
        
        sc.close();
    }
}
