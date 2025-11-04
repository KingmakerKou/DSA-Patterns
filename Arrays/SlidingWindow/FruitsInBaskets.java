// this can be converted to Maximum length of the subarray with at most 2 different numbers
import java.util.HashMap;
import java.util.Map;

class Solution {

    // Approach:
    // Use a sliding window with a HashMap to store counts of fruit types.
    // Expand right pointer, and when more than 2 types appear, shrink from left.
    // Track the maximum window size with at most 2 distinct fruits.

    // Time Complexity: O(n) — each element is visited at most twice (left & right pointers).
    // Space Complexity: O(1) — HashMap holds at most 2 fruit types.

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
