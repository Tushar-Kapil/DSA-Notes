package Graphs;

import java.util.ArrayList;
// import java.util.Arrays;

public class AdjList {

    public static void main(String[] args) {
        int n = 3;
        // int m = 3;

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }

        // 1--2
        adjlist.get(1).add(2);
        adjlist.get(2).add(1);

        // 2--3
        adjlist.get(2).add(3);
        adjlist.get(3).add(2);

        // 1--3
        adjlist.get(1).add(3);
        adjlist.get(3).add(1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adjlist.get(i).size(); j++) {
                System.out.print(adjlist.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
