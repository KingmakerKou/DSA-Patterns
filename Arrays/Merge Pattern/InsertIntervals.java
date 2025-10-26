// 🧩 Insert Interval
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with newInterval
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        res.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
