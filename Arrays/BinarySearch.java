
package Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 7, 8, 9, 10 };

        int target = 10;

        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
