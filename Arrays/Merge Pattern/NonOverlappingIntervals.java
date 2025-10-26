// 🧩 Erase Overlap Intervals
// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        // Sort by end time to keep maximum non-overlapping intervals
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return n - count; // Minimum intervals to remove
    }
}

// this is done using of N meetings in one room problem --> it tells number of non overlapping intervals . if we subtract total - count_of_nonOverlapping .. we 
//will remove the overlapping intervals
