package TwoPointer;

public class IsSubseq {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
