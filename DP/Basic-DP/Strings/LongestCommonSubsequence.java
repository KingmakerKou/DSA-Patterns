//find the common subsequence between two strins
//recursion
class Solution {
    private int f(int ind1 , int ind2,String text1 , String text2){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            return 1 + f(ind1-1 , ind2-1 , text1 , text2);
        }
        return Math.max(f(ind1-1 , ind2,text1,text2) , f(ind1,ind2-1,text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return f(n-1,m-1,text1,text2);
    }
}
//time -> O( 2^n x 2^m -> 2^n+m)
//space -> O(n + m)

//memoization
class Solution {
    private int f(int ind1 , int ind2,String text1 , String text2 ,int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            return 1 + f(ind1-1 , ind2-1 , text1 , text2,dp);
        }
        return dp[ind1][ind2] =  Math.max(f(ind1-1 , ind2,text1,text2,dp) , f(ind1,ind2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,text1,text2,dp);
    }
}
//Time Complexity: O(N*M), N is the length of string S1 and M is the length of string S2. There are N*M states therefore at max ‘N*M’ new problems will be solved.

//Space Complexity:O(N*M) + O(N+M), We are using an auxiliary recursion stack space(O(N+M)) and a 2D array (O(N*M)).

//tabulation
//in base case we cant store the negative indexes so that we are shifting the indexes to +1 
//so -1 becomes 0 .. 0 becomes 1 ..so on ...
class Solution {
    private int f(int ind1 , int ind2,String text1 , String text2 ,int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            return 1 + f(ind1-1 , ind2-1 , text1 , text2,dp);
        }
        return dp[ind1][ind2] =  Math.max(f(ind1-1 , ind2,text1,text2,dp) , f(ind1,ind2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
        }
    return dp[n][m];
    }
}

