package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Kahns {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ind = new int[V];

        // calc indegree
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                ind[it]++;
            }
        }

        // indegree 0 push
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            topo[i++] = node;
            q.remove();

            for (Integer it : adj.get(node)) {
                ind[it]--;
                if (ind[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
