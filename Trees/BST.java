package Trees;

import java.util.LinkedList;

import java.util.Queue;

public class BST {
    class Node {
        int value;
        int hieght;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public int hieght(Node node) {
        if (node == null) {
            return -1;
        }
        return node.hieght;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.hieght = Math.max(hieght(node.left), hieght(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(hieght(node.left) - hieght(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    void levelOrderDisplay() {
        levelOrderDisplay(root);
    }

    private void levelOrderDisplay(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                if (q.isEmpty()) {
                    return;
                }
                q.add(null);
                System.out.println();

            } else {
                System.out.print(temp.value + " ");

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);

        display(node.left);
        display(node.right);

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + ",");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + ",");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + ",");
    }

    public static void main(String[] args) {
        int[] nodes = { 15, 10, 5, 20, 12, 8 };

        BST bst = new BST();
        bst.populate(nodes);
        bst.display();
    }
}
