/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Approach: Sliding Window + Last Seen Index Table
 *
 * We maintain a sliding window [l..r] such that it contains no duplicate characters.
 * For each character, we check if it has appeared before inside the current window:
 *    - If yes, we move `l` to one position right of where this character was last seen.
 * Then update the maximum window length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)   (since character set is bounded to ASCII: 256)
 */

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);

        int l = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);

            // If this character was seen inside the current window,
            // move the left pointer to avoid repetition
            if (lastSeen[ch] >= l) {
                l = lastSeen[ch] + 1;
            }

            // Update max window length
            maxLen = Math.max(maxLen, r - l + 1);

            // Record current position
            lastSeen[ch] = r;
        }

        return maxLen;
    }
}
