package Graphs;

import java.util.ArrayList;

class CycWithDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (dfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (it == parent) {
                continue;
            }

            if (vis[it] == true) {
                return true;
            }

            if (dfs(adj, vis, it, node) == true) {
                return true;
            }
        }

        return false;
    }
}