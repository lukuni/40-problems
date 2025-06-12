import java.io.*;

class Node {
    int val;
    Node left;
    Node right;
    int ht;
}

class Solution {

    // Get height of a node
    static int height(Node node) {
        return (node == null) ? -1 : node.ht;
    }

    // Update height
    static void updateHeight(Node node) {
        node.ht = 1 + Math.max(height(node.left), height(node.right));
    }

    // Get balance factor
    static int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation (LL)
    static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Left rotation (RR)
    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Insert into AVL Tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.ht = 0;
            return newNode;
        }

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);
        else
            return root; // no duplicates

        updateHeight(root);
        int balance = getBalance(root);

        // Left Left (LL)
        if (balance > 1 && val < root.left.val)
            return rotateRight(root);

        // Right Right (RR)
        if (balance < -1 && val > root.right.val)
            return rotateLeft(root);

        // Left Right (LR)
        if (balance > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Left (RL)
        if (balance < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }
}
