//same as 0 / 1 knapsack but we can take how many times as we want
//recursion
class Solution {
    private int f(int ind , int[] val , int[] wt , int W){
        if(ind == 0){
            return (W/wt[0]) * val[ind];
        }
        int notake = f(ind-1 , val , wt , W);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + f(ind , val , wt , W-wt[ind]);
        }
        return Math.max(notake , take);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        return f(n-1 , val , wt , capacity);
        
    }
}

//memoization
class Solution {
    private int f(int ind , int[] val , int[] wt , int W,int[][] dp){
        if(ind == 0){
            return (W/wt[0]) * val[ind];
        }
        if(dp[ind][W] != -1){
            return dp[ind][W];
        }
        int notake = f(ind-1 , val , wt , W,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + f(ind , val , wt , W-wt[ind],dp);
        }
        return dp[ind][W] = Math.max(notake , take);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return f(n-1 , val , wt , capacity,dp);
        
    }
}

//time -> O( n * W)
//space => O( n * W)

//tabulation
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        
        for(int i = 0 ; i<=capacity ; i++){
            dp[0][i] = (i/wt[0]) * val[0];
        }
        
        for(int i=1;i<n;i++){
            for(int j = 0 ; j <= capacity ; j++){
                int notake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= j){
                    take = val[i] + dp[i][j-wt[i]];
                }
            dp[i][j] = Math.max(notake , take);
            }   
        }
    return dp[n-1][capacity];
    }
}
//time - > O (n * W)
//space -> O ( n * W)

//time -> 
