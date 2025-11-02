//constant window solution
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        int rind = n - 1;
        int rsum = 0, maxsum = lsum;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rind];
            rind--;
            maxsum = Math.max(maxsum, lsum + rsum);
        }
        return maxsum;
    }
}

/*
Approach:
- Take the sum of the first k cards from the left.
- Then iteratively remove one card from the left and add one from the right.
- Track the maximum total during each iteration.

Time Complexity: O(k)
Space Complexity: O(1)
*/
