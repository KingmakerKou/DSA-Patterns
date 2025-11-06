/*
--------------------------------------------------------------
Problem: Find Common Meeting Slot of Duration D
--------------------------------------------------------------
You are given two employee availability schedules:

    List<int[]> a → employee A's free intervals
    List<int[]> b → employee B's free intervals

Each interval is of form: [start, end]
And you are also given an integer d → required meeting duration.

Task:
Return a common interval of at least length d where both employees are free.
If multiple valid slots exist, return the earliest one.
If no such slot exists, return an empty array.

--------------------------------------------------------------
Approach:
1. Sort both lists based on start times.
2. Use two pointers (i, j) to compare intervals.
3. For each pair, compute:
        start = max(a[i].start, b[j].start)
        end   = min(a[i].end,   b[j].end)
4. If (end - start) >= d → we found a valid common duration → return {start, start + d}
5. Move the pointer of the interval that ends first.
6. If pointers reach end, no answer → return empty array.

This works because sorting + two pointer scanning ensures earliest feasible match.

--------------------------------------------------------------
Time Complexity:  O(n log n + m log m + n + m)
    Sorting both lists + single linear scan.
Space Complexity: O(1)
    No extra storage besides returned array.
--------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int[] commonSlot(List<int[]> a, List<int[]> b, int d) {

        // Sort based on start time
        Collections.sort(a, (x, y) -> x[0] - y[0]);
        Collections.sort(b, (x, y) -> x[0] - y[0]);

        int i = 0, j = 0;

        // Two pointer sweep to find overlapping intervals
        while(i < a.size() && j < b.size()) {

            int start = Math.max(a.get(i)[0], b.get(j)[0]);
            int end   = Math.min(a.get(i)[1], b.get(j)[1]);

            // If overlap length >= required duration
            if(end - start >= d) {
                return new int[]{start, start + d};
            }

            // Move pointer of interval that ends first
            if(a.get(i)[1] < b.get(j)[1]) {
                i++;
            } else {
                j++;
            }
        }

        // No valid common slot found
        return new int[]{};
    }
}
