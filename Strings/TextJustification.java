package Strings;

import java.util.ArrayList;
import java.util.List;

class TextJustification {
    int MAX_WIDTH;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;

        int i = 0;

        MAX_WIDTH = maxWidth;

        while (i < n) {
            int letterCount = words[i].length(); // 8
            int defaultSpace = 0; // 2
            int j = i + 1; // 3

            while (j < n && words[j].length() + 1 + letterCount + defaultSpace <= MAX_WIDTH) {
                letterCount += words[j].length();
                defaultSpace += 1;
                j++;
            }

            int remainingSpaces = MAX_WIDTH - letterCount; // 8
            int betweenWordSpace = defaultSpace == 0 ? 0 : remainingSpaces / defaultSpace; // 4
            int extraWordSpace = defaultSpace == 0 ? 0 : remainingSpaces % defaultSpace; // 0

            if (j == n) {
                betweenWordSpace = 1;
                extraWordSpace = 0;
            }

            ans.add(findLine(i, j, betweenWordSpace, extraWordSpace, words));

            i = j;
        }

        return ans;
    }

    public String findLine(int i, int j, int betweenWordSpace, int extraWordSpace, String[] words) {
        StringBuilder line = new StringBuilder();

        for (int k = i; k < j; k++) {
            line.append(words[k]);

            if (k == j - 1) {
                continue;
            }

            for (int z = 0; z < betweenWordSpace; z++) {
                line.append(" ");
            }

            if (extraWordSpace > 0) {
                line.append(" ");
                extraWordSpace--;
            }
        }

        while (line.length() < MAX_WIDTH) {
            line.append(" ");
        }

        return line.toString();
    }
}