
package MultidimesionalArrays;

import java.util.Arrays;
import java.util.Stack;

class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> s = new Stack<>();
        s.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] poped = s.pop();
            int start1 = poped[0];
            int end1 = poped[1];

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (start2 <= end1) {
                s.push(new int[] { start1, Math.max(end1, end2) });
            } else {
                s.push(poped);
                s.push(intervals[i]);
            }
        }

        int[][] result = new int[s.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            int[] poped = s.pop();
            result[i][0] = poped[0];
            result[i][1] = poped[1];
        }

        return result;

    }
}
