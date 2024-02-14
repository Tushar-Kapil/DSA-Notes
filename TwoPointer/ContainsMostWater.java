package TwoPointer;

public class ContainsMostWater {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int res = 0;

        while (left < right) {
            res = Math.max(res, Math.min(arr[left], arr[right]) * (right - left));

            if (arr[left] <= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

}
