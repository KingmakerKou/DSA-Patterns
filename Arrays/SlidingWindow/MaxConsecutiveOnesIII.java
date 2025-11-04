/**
 * 1004. Max Consecutive Ones III
 *
 * We want the longest subarray containing at most k zeros.
 * This is a classic Sliding Window problem.
 *
 * Window Invariant:
 *   The window [l..r] must contain <= k zeros.
 *
 * Steps:
 *  - Expand r: include nums[r]. If it's zero, increase zero count.
 *  - While zero count > k, shrink window from left by moving l forward,
 *    and reduce zero count when passing a zero.
 *  - Track the maximum window length at every step.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
// we can convert this problem to find the Longest subarray with at most one's

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, zeroes = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {

            // Expand window
            if (nums[r] == 0) zeroes++;

            // Shrink window to restore inva
