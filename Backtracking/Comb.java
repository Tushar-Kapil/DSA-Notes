package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Comb {

    public void solve(int n, int k, int start, List<Integer> temp, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start > n) {
            return;
        }

        temp.add(start);
        solve(n, k - 1, start + 1, temp, result);

        temp.remove(temp.size() - 1);
        solve(n, k, start + 1, temp, result);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solve(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        Comb comb = new Comb();
        List<List<Integer>> result = comb.combine(4, 2);
        System.out.println(result);
    }
}
