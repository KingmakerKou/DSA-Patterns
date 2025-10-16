/*
Problem: 3Sum
Source: LeetCode #15
Link: https://leetcode.com/problems/3sum
Language: Java
Author: Koushik Mahesh

Approach:
- Sort array, then for each i use two pointers (j=i+1, k=n-1)
- Skip duplicates for i, j and k
Time Complexity: O(n^2)
Space Complexity: O(1) (excluding output)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= n - 3; i++) {
            // If current value > 0, no three values can sum to 0 (array sorted)
            if (nums[i] > 0) break;

            // Skip duplicates for the fixed element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates for j and k by moving them
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }
}
