package DynamicProgramming.Subseq;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        // int n = nums.length;

        return solve(0, nums, target, 0);
    }

    public int solve(int ind, int[] nums, int target, int currSum) {
        if (ind == nums.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int minus = solve(ind + 1, nums, target, currSum - nums[ind]);
        int plus = solve(ind + 1, nums, target, currSum + nums[ind]);

        return plus + minus;
    }
}
