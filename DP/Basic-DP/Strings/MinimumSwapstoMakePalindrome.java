//greedy + 2 pointers technique


//time - > O(n^2)
//Idea (greedy two-pointer)

// Use two pointers i = 0 and j = n-1:

// If s[i] == s[j]: those characters are matched — move i++, j--.

// Else: search from k = j down to i for a position where s[k] == s[i].

// If you find such k < j: move the character at k to position j by swapping it rightwards with adjacent swaps.
//Each swap increments the answer by 1. After moving it to j, s[i] and s[j] are matched → i++, j--.

// If you don't find such k (i.e., k == i): that means s[i] is the (unique) center character in an odd-length palindrome. 
//Swap s[i] with s[i+1] (one adjacent swap), increment count, and retry (do not advance pointers).

// Because the input guarantees a palindrome can be formed, there will be at most one character with odd frequency; the k==i case handles that center character by nudging it toward center.

// This greedy is correct because whenever a match exists for s[i] on the right, 
//moving the rightmost matching character to j using adjacent swaps is locally optimal — it costs the minimum number of adjacent swaps to pair s[i] with a mirror position.



class Solution {
    private int lcs(String s , String s1){
        int n = s.length();
        int m = s1.length();
        int[][] dp = new int[n+1][m+1];
    
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i - 1 ) == s1.charAt(j-1)){
                    dp[i][j] =  1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] =  Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
                
        
            }
        }
        
    return dp[n][m];
    }
    public int longestPalindromeSubseq(String s) {
        //just find the longest common subsequence between the s1 and reverse s1;
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        String s1 = str.toString();
        return lcs(s , s1);
    }
    public int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromeSubseq(s);
        return n - k;
    }
}
