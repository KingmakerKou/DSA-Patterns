// doesnt come under sliding window appraoch

/**
 * 152. Maximum Product Subarray
 *
 * Strategy: Two linear scans with running products from both ends.
 * - Multiply a running product from left→right (prefix) and right→left (suffix).
 * - If a running product becomes 0, reset to 1 (zero splits the array into segments).
 * - At each step, the answer is the max of prefix/suffix so far.
 *
 * Why this works:
 * - Negative numbers flip sign; an even count of negatives in a segment yields a positive product.
 * - The best subarray could be captured only from one side depending on where negatives/zeros lie,
 *   so we take max over both passes.
 *
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            // reset running product if it became 0 in the previous step
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
