//same as minimum coins problem .. in this problem we have to find the number of total ways/distinct way we can sum up the target
//recursion
class Solution {
    public int f(int ind , int target , int[] coins){
        if(ind == 0){
            return (target % coins[ind] == 0) ? 1 : 0;    
        }
        int notake = f(ind-1,target,coins);
        int take = 0;
        if(coins[ind] <= target){
            take = f(ind , target - coins[ind] , coins);
        }
        return take + notake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return f(n-1,amount,coins);
    }
}
// Time Complexity:O(2N), as there are N coints can each one of them has 2 options.

// Space Complexity:O(N), the depth of the recursion stack can be N at max.

//memoization
class Solution {
    public int f(int ind , int target , int[] coins,int[][]dp){
        if(ind == 0){
            return (target % coins[ind] == 0) ? 1 : 0;    
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int notake = f(ind-1,target,coins,dp);
        int take = 0;
        if(coins[ind] <= target){
            take = f(ind , target - coins[ind] , coins,dp);
        }
        return dp[ind][target] =  take + notake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,amount,coins,dp);
    }
}
//time : O ( n * amount)
//space : O( n * amount)

//tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notake = dp[i-1][t];
                int take = 0;
                    if(coins[i] <= t){
                        take = dp[i][t - coins[i]];
                    }
            dp[i][t] =  take + notake;
            }
        }
        int ans = (dp[n-1][amount]);
        return ans;
    }
}
