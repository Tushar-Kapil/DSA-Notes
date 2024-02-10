package Recursion;

public class PrintN {

    static int count = 1;

    public static void main(String[] args) {
        // Print 1 to N
        printCount();
    }

    public static void printCount() {
        if (count == 4) {
            return;
        }
        System.out.println(count);
        count++;
        printCount();
    }
}
