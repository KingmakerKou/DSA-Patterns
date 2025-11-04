/**
 * 845. Longest Mountain in Array
 * 
 * A "mountain" is a subarray that strictly increases then strictly decreases,
 * with at least one up step and one down step (length >= 3).
 *
 * Approach: One-pass Peak Expansion (O(n) time, O(1) space)
 * - Scan for peaks where arr[i] > arr[i-1] && arr[i] > arr[i+1].
 * - From each peak:
 *     * Expand left while arr[l] > arr[l-1] (strictly increasing toward peak).
 *     * Expand right while arr[r] > arr[r+1] (strictly decreasing from peak).
 *   Length = r - l + 1. Update answer.
 * - Jump i to r (end of this mountain) to keep overall O(n).
 *
 * Handles plateaus (equal neighbors) by definition (they break strictness).
 */

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;

        for(int i = 1; i <= n - 2; i++) {

            // Check if arr[i] is a peak
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                int count = 1;   // count includes the peak
                int j = i;

                // Expand left (strictly increasing toward peak)
                while(j > 0 && arr[j] > arr[j - 1]) {
                    count++;
                    j--;
                }

                // Expand right (strictly decreasing away from peak)
                j = i; // reset pointer to peak
                while(j < n - 1 && arr[j] > arr[j + 1]) {
                    count++;
                    j++;
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }
}
