package Graphs.Algorithms;

import java.util.ArrayList;

public class Dfs {

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, adj, ls, vis);
        return ls;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls, boolean[] vis) {
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, adj, ls, vis);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    }
}
