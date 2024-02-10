package Recursion;

class PrintSumFunc {
    public static void main(String[] args) {
        System.out.println(printSum(3));
    }

    public static int printSum(int n) {
        if (n == 0) {
            return 0;
        }

        return n + printSum(n - 1);
    }
}