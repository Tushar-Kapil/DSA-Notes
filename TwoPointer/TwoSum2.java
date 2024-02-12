package TwoPointer;

public class TwoSum2 {
    public int[] twoSum(int[] arr, int target) {
        // [2, 7, 11, 15]

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (arr[left] + arr[right] > target) {
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                break;
            }
        }

        int[] ans = new int[2];
        ans[0] = left + 1;
        ans[1] = right + 1;

        return ans;
    }
}
