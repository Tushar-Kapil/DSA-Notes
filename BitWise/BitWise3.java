package BitWise;

public class BitWise3 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 3, 4, 4, 6 };

        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique = unique ^ n;
        }

        return unique;
    }
}
