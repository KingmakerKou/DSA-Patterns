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
}
