package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public void helper(int ind, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        } else {
            temp.add(nums[ind]);
            helper(ind + 1, nums, temp, ans);

            temp.remove(temp.size() - 1);
            helper(ind + 1, nums, temp, ans);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = subsets.subsets(nums);
        System.out.println(ans);
    }
}
