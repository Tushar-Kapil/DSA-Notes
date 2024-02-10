package Recursion;

public class PrintSumN {
    // Parameterised
    public static void main(String[] args) {
        // Sum of first N numbers
        sumFirstN(3, 0);
    }

    public static void sumFirstN(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }

        sumFirstN(n - 1, sum + n);
    }
}
