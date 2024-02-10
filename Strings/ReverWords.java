package Strings;

public class ReverWords {

    public String reverseWords(String s) {
        s.trim();

        String[] str = s.split(" ");
        String[] str2 = new String[str.length];

        for (int i = 0; i < str.length; i++) {
            if (str[i] == "") {
                continue;
            } else {
                str2[i] = str[i];
            }

        }

        StringBuilder ans = new StringBuilder();

        for (int i = str2.length - 1; i >= 0; i--) {
            if (str2[i] != null) {
                ans.append(str2[i] + " ");
            }
        }

        String res = ans.toString();
        return res.trim();
    }

}
