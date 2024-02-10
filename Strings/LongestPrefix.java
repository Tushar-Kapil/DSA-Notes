package Strings;

import java.util.Arrays;

public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(strs);

        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            ans.append(strs[0].charAt(i));
        }

        return ans.toString();
    }

}
