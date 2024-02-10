package Recursion;

public class Palin {

    public static void main(String[] args) {
        String name = "madam";

        System.out.println(checkPalindrome(name, 0, name.length()));
    }

    private static boolean checkPalindrome(String name, int i, int length) {
        if (i >= length / 2) {
            return true;
        }

        if (name.charAt(i) != name.charAt(length - i - 1)) {
            return false;
        }

        return checkPalindrome(name, i + 1, length);
    }
}
