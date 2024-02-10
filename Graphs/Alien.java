package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Alien {
    public List<Integer> topoSort(int v, List<List<Integer>> adj) {
        int[] ind = new int[v];

        // calc indegree
        for (int i = 0; i < v; i++) {
            for (Integer it : adj.get(i)) {
                ind[it]++;
            }
        }

        // indegree 0 push
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.peek();
            topo.add(node);
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

    public String findOrder(String[] dict, int N, int K) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";

        for (int it : topo) {
            ans = ans + (char) (it + (int) ('a'));
        }

        return ans;
    }
}