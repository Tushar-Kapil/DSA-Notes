package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class Hindex {

    public int hIndex(int[] citations) {

        int n = citations.length;
        Integer[] c = new Integer[n];

        for (int i = 0; i < n; i++) {
            c[i] = citations[i];
        }

        Arrays.sort(c, Collections.reverseOrder());

        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= i + 1) {
                cnt++;
            } else {
                return i;
            }
        }

        return cnt;
    }

}
