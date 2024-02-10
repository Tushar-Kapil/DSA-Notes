package Graphs;

import java.util.ArrayList;
import java.util.List;

class FindSafe {

    public static boolean check(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;

        check[node] = 0;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                if (check(it, adj, vis, pathVis, check) == true) {
                    return true;
                }

            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                ls.add(graph[i][j]);
            }
            adj.add(ls);
        }

        List<Integer> safe = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                check(i, adj, vis, pathVis, check);
            }
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                safe.add(i);
            }
        }
        return safe;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {}
        };
        List<Integer> an = eventualSafeNodes(graph);
        System.out.println(an);
    }
}