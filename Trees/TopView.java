package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class TopeView {
    static ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair it = q.poll();
            Node node = it.node;
            int hd = it.hd;

            // For bottom view always update without check
            if (map.get(hd) == null) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }

        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            ans.add(it.getValue());
        }

        return ans;

    }
}
