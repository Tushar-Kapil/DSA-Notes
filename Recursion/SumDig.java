package Recursion;

public class SumDig {

    public static void main(String[] args) {
        int res = sum(123);
        System.out.println(res);
    }

    static int sum(int num) {

        if (num == 0) {
            return 0;
        }

        return (num % 10) + sum(num / 10);
    }
}
