package Strings;

public class LenOfLastWord {

    public int lengthOfLastWord(String s) {
        String st = s.trim();

        int len = 0;

        for (int i = st.length() - 1; i >= 0; i--) {
            if (st.charAt(i) == ' ') {
                return len;
            } else {
                len++;
            }
        }

        return len;
    }

}
