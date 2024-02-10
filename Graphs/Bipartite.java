package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Bipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Convert the given graph to an adjacency list
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
            n++;
        }

        // Initialize an array to store the color of each node
        int color[] = new int[n];
        Arrays.fill(color, -1);

        // Check each component of the graph for bipartiteness
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                // If any component is not bipartite, return false
                if (check(i, adj, color) == false) {
                    return false;
                }
            }
        }

        // All components are bipartite
        return true;
    }

    public static boolean check(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[start] = 0;

        q.add(start);

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}