package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int V, int[] vis, Stack<Integer> st) {
        vis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, V, vis, st);
            }
        }

        st.push(node);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, V, vis, st);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i] = st.peek();
            i++;
            st.pop();
        }

        return ans;
    }
}