/*
Problem: Two Sum
Source: LeetCode #1
Link: https://leetcode.com/problems/two-sum
Language: Java
Author: Koushik Mahesh

Approach:
- Use HashMap to store value -> index
- For each element, check if target - current exists
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
