package Graphs;

import java.util.ArrayList;

class Provinces {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] vis = new boolean[isConnected[0].length];

        for (int i = 0; i < isConnected[0].length; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }
}
