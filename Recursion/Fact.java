package Recursion;

public class Fact {

    public static void main(String[] args) {
        int res = factorial(3);
        System.out.println(res);
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
