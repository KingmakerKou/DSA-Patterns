//brute force appraoch
✅ Brute Force Approach (Your Code Logic)
Goal

Find the longest substring that can be turned into a substring of all the same characters using at most k replacements.

Key Idea

For any substring:

Find the most frequent character in that substring.

If we make the substring uniform, we would convert all other characters into that most frequent character.

So, number of required replacements is:

changes = (window length) - (max frequency character in window)


If:

changes ≤ k  →  substring is valid


Else:

stop expanding that substring (because adding more characters will only increase changes)

🧠 Algorithm (Brute Force)

Loop over all possible starting indices i of the substring.

For each start, maintain a frequency array to count characters.

Expand the end of the substring using pointer j.

Update the frequency of the character at position j.

Track maxfreq → the highest count of any one character in this window.

Compute:

changes = (j - i + 1) - maxfreq


If changes <= k, update maxlen.

If changes > k, break, because further expansion will only increase changes.

Continue for next starting index.

⏱ Complexity (Brute Force)
Aspect	Value
Time Complexity	O(n²) (nested loops)
Space Complexity	O(1) (frequency array of size 26)
✅ One-line Interview Explanation

We try every possible substring. For each substring, we count character frequencies and check how many characters must be replaced to make the substring uniform. If the number of required replacements is ≤ k, we update the longest valid substring.

Example to Understand Quickly

Substring: "AABA", k = 1
Frequency:

A: 3
B: 1


Length = 4, most frequent = 3
Replacements needed = 4 - 3 = 1 ≤ k → valid ✅



code:
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0;
        for(int i=0;i<n;i++){
            int[] hash = new int[26];
            int maxfreq = 0;
            for(int j=i;j<n;j++){
                hash[s.charAt(j) - 'A']++;
                maxfreq = Math.max(maxfreq , hash[s.charAt(j) - 'A']);
                int changes = (j-i+1) - maxfreq;
                if(changes <= k){
                    maxlen = Math.max(maxlen , j-i+1);
                }else{
                    break;
                }
            }
        }
    return maxlen;
    }
}



//optimal
/**
 * 424. Longest Repeating Character Replacement
 *
 * Sliding Window + Frequency Array
 *
 * Invariant:
 *   Keep a window [l..r] where (window length - maxFreq) <= k.
 *   That means we can replace at most k characters to make the whole window the same char.
 *
 * Key Detail:
 *   We track maxFreq as the maximum count of any single character seen in the *current* window.
 *   We don't decrease maxFreq when shrinking; a slightly stale maxFreq is safe and keeps O(n) time.
 *
 * Time: O(n)
 * Space: O(1)  // constant 26-length frequency table
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] freq = new int[26];

        while (r < n) {
            int cr = s.charAt(r) - 'A';
            freq[cr]++;
            maxFreq = Math.max(maxFreq, freq[cr]);

            // If more than k replacements needed, shrink from left
            while ((r - l + 1) - maxFreq > k) {
                int cl = s.charAt(l) - 'A';
                freq[cl]--;
                l++;
            }

            // Now window [l..r] is valid
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
