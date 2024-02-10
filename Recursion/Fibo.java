package Recursion;

public class Fibo {

    public static void main(String[] args) {
        int res = fibo(4);
        System.out.println(res);
    }

    static int fibo(int n) {

        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}