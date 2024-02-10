package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class NumOfWaysDes {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = roads.length;

        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair1, Pair2) -> Long.compare(Pair1.first, Pair2.first));

        long dist[] = new long[n];
        long ways[] = new long[n];
        long mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (pq.size() != 0) {
            long dis = pq.peek().first;
            long node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get((int) node)) {
                long adjNode = it.first;
                long edW = it.second;

                if (dis + edW < dist[(int) adjNode]) {
                    dist[(int) adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[(int) adjNode] = ways[(int) node];
                } else if (dis + edW == dist[(int) adjNode]) {
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}