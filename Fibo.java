import java.util.Arrays;
import java.util.Scanner;

public class Fibo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter Fib Number: ");
        System.out.println("Enter Fibo Tab: ");
        int n = sc.nextInt();

        // System.out.println(fib(n));

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // Arrays.fill(dp, -1);

        // System.out.print("Enter FibMemo Number: ");
        // System.out.println(fibMemo(n, dp));
        System.out.println(fiboTab(n, dp));

        sc.close();
    }

    public static int fiboTab(int n, int[] dp) {

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibMemo(int n, int[] dp) {
        if (n == 1 || n == 0) {
            return n;
        }

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
    }
}
