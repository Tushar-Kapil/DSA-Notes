package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dis = new int[V];

        Arrays.fill(dis, (int) (1e8));
        dis[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dis[u] != (int) (1e8) && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }

        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dis[u] != (int) (1e8) && dis[u] + wt < dis[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dis;
    }
}
