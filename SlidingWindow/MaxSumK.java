package SlidingWindow;

public class MaxSumK {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
    }

    public static int maxSum(int[] nums, int k) {
        // [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
        int max = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];

            if (i >= k - 1) {
                max = Math.max(max, current);
                current -= nums[i - (k - 1)];
            }
        }

        return max;
    }
}
