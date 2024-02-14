package SlidingWindow;

public class MinSumTarget {

    public static void main(String[] args) {
        System.out.println(minSum(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 8));
    }

    public static int minSum(int[] nums, int target) {
        // [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
        int currentWindowSum = 0;
        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd];

            while (currentWindowSum >= target) {
                minWindowSize = Math.min(minWindowSize, (windowEnd - windowStart + 1));
                currentWindowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minWindowSize;
    }
}