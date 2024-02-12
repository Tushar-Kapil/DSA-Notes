package TwoPointer;

public class ValidPalin {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int first = 0;
        int last = s.length() - 1;

        while (first < last) {

            if (!Character.isLetterOrDigit(s.charAt(first))) {
                first++;
            } else if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            } else {
                if (Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))) {
                    return false;
                }

                first++;
                last--;
            }
        }

        return true;
    }

}
