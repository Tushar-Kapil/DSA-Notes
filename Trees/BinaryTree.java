package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    public void populate(Scanner sc) {
        System.out.print("Enter the Root Node: ");

        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.print("Want to enter to left of " + node.value + "? ");
        boolean left = sc.nextBoolean();

        if (left) {
            System.out.print("Enter to left of " + node.value + ": ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.print("Want to enter to right of " + node.value + "? ");
        boolean right = sc.nextBoolean();

        if (right) {
            System.out.print("Enter to right of " + node.value + ": ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
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

    public void inOrder() {
        inOrder(root);
    }

    // L -> N -> R
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + ",");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    // N -> L -> R
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + ",");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    // L -> R -> N
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + ",");
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    // Initally add the root node
    // poll and print the node
    // add left and right childs if not null
    // keep repeating until queue empty
    public void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.print(temp.value + " ");

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        // tree.display();
        // tree.inOrder();
        // System.out.println();
        // tree.preOrder();
        // System.out.println();
        // tree.postOrder();
        // System.out.println();
        tree.levelOrderTraversal();
    }
}

// Hieght -> The height of a node is the number of nodes from the node to the
// deepest leaf.

// A full Binary tree is a special type of binary tree in which every parent
// node has either two or no children.

// A perfect binary tree is a type of binary tree in which every internal node
// has exactly two child nodes and all the leaf nodes are at the same level.

// A complete binary tree is just like a full binary tree, but with two major
// differences
// 1.Every level must be completely filled
// 2.All the leaf elements must lean towards the left.
// 3.The last leaf element might not have a right sibling i.e. a complete binary
// tree doesn't have to be a full binary tree.

// It is a type of binary tree in which the difference between the height of the
// left and the right subtree for each node is either 0 or 1.