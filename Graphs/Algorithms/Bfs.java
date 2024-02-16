package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // [[1, 2, 3], [], [4], []]
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }

        return bfs;
    }
}