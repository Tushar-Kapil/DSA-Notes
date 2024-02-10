package Graphs.Algorithms;

import java.util.ArrayList;

public class Dfs {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, adj, ls, vis);
        return ls;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls, boolean[] vis) {
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, adj, ls, vis);
            }
        }
    }
}
