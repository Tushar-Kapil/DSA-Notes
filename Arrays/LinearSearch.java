package Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 7, 8, 6 };
        int target = 10;

        System.out.println(linearSearch(arr, target));
    }

    static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
