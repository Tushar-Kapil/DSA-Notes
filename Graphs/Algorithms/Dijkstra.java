package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Dijkstra {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = (int) (1e9);
        }

        dis[S] = 0;

        pq.add(new Pair(0, S));

        while (pq.size() != 0) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeW = adj.get(node).get(i).get(1);
                int adjN = adj.get(node).get(i).get(0);

                if (distance + edgeW < dis[adjN]) {
                    dis[adjN] = distance + edgeW;
                    pq.add(new Pair(dis[adjN], adjN));
                }
            }
        }

        return dis;
    }
}