package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int src;
    int parent;

    Pair(int src, int parent) {
        this.src = src;
        this.parent = parent;
    }
}

class DetectCycUG {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 1; i < V; i++) {
            if (vis[i] == false) {
                if (detect(adj, i, V, vis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detect(ArrayList<ArrayList<Integer>> adj, int src, int V, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;

        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().src;
            int parent = q.peek().parent;
            q.remove();

            for (int adjNode : adj.get(node)) {
                if (vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
}
