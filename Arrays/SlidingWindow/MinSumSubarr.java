/**
 * 209. Minimum Size Subarray Sum
 * Difficulty: Medium
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * 
 * Example:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        // Expand right boundary of window
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink from left while sum is valid
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        // If no valid subarray found, return 0
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
