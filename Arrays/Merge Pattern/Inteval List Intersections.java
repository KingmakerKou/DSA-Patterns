// 🧩 Interval List Intersections (LeetCode 986)
// Time Complexity: O(m + n)
// Space Complexity: O(k) — k = number of intersections

import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end   = Math.min(A[i][1], B[j][1]);

            if (start <= end)
                res.add(new int[]{start, end});

            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
