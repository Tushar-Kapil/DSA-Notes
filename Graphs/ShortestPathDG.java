package Graphs;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class ShortestPathDG {

    public void topo(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;

            if (vis[v] == 0) {
                topo(v, adj, vis, st);
            }
        }

        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topo(i, adj, vis, st);
            }
        }

        int[] dis = new int[N];

        for (int i = 0; i < N; i++) {
            dis[i] = (int) (1e9);
        }

        dis[0] = 0;

        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dis[node] + wt < dis[v]) {
                    dis[v] = dis[node] + wt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dis[i] == (int) (1e9)) {
                dis[i] = -1;
            }
        }
        return dis;
    }
}
