package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeating {

    public int lengthOfLongestSubstring(String s) {
        // "pwwkew"
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);

            if (map.containsKey(currChar)) {
                windowStart = Math.max(windowStart, map.get(currChar) + 1);
            }

            map.put(currChar, windowEnd);
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        }

        return maxLength;

    }
}
