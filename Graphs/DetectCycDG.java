package Graphs;

import java.util.ArrayList;

class DetectCycDG {

    public static boolean checkForCycle(int start, ArrayList<ArrayList<Integer>> adj, int V, int[] vis,
            int[] pathVis) {
        vis[start] = 1;
        pathVis[start] = 1;

        for (Integer it : adj.get(start)) {
            if (vis[it] == 0) {
                if (checkForCycle(it, adj, V, vis, pathVis) == true) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[start] = 0;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (checkForCycle(i, adj, V, vis, pathVis) == true) {
                    return true;
                }
            }
        }

        return false;
    }
}
