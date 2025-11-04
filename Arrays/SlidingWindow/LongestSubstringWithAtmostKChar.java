//find the longest substring with atmost k distinct characters

//brute force -> generate all the subarrays
class Solution {
    public int kDistinctChar(String s, int k) {
        //your code goes here
        int n = s.length();
        int maxlen = 0;
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(s.charAt(j));
                if(set.size() > k){
                    break;
                }
                if(set.size() <= k){
                    maxlen = Math.max(maxlen , j - i + 1);
                }
            }
        }
    return maxlen;
    }
}

//better -> sliding window + 2 pointers 
/**
 * Longest Substring with At Most K Distinct Characters
 *
 * Pattern: Sliding Window + HashMap (freq table)
 *
 * Invariant:
 *   Maintain a window [l..r] whose number of distinct characters <= k.
 *   If it exceeds k, shrink from the left until the invariant is restored.
 *
 * Time Complexity: O(n) — each character enters & leaves the window at most once.
 * Space Complexity: O(min(n, k)) — frequency map of chars in the current window.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int kDistinctChar(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        int n = s.length();
        int l = 0, maxLen = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char cr = s.charAt(r);
            freq.put(cr, freq.getOrDefault(cr, 0) + 1);

            // Shrink while we have more than k distinct characters
            while (freq.size() > k) {
                char cl = s.charAt(l);
                freq.put(cl, freq.get(cl) - 1);
                if (freq.get(cl) == 0) freq.remove(cl);
                l++;
            }

            // Now window [l..r] has at most k distinct characters
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
