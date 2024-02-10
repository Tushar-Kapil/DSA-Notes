package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

class kosaraju {

    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }

    public void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs2(it, vis, adj);
            }
        }
    }

    public int kosarajus(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjR.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                adjR.get(it).add(i);
            }
        }

        int scc = 0;

        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs2(node, vis, adjR);
            }
        }

        return scc;
    }
}