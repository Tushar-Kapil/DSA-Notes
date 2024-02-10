package Recursion;

public class CountZ {

    public static void main(String[] args) {
        int res = countZero(30204);

        System.out.println(res);

    }

    static int count = 0;

    static int countZero(int num) {

        if (num == 0) {
            return 0;
        }
        int rem = num % 10;

        if (rem == 0) {
            count++;
        }

        return countZero(num / 10);

    }
}
