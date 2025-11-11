//recursion
class Solution {
    public int f(int ind , int target,int[] coins){
        if(ind == 0){
            if(target % coins[ind] == 0){
                return target / coins[ind];
            }else{
                return (int)1e9;
            }
        }
        int notTake = 0 + f(ind-1,target,coins);
        int take = (int)1e9;
        if(coins[ind] <= target){
            take = 1 + f(ind , target-coins[ind] , coins);
        }
        return Math.min(take , notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans =  f(n-1,amount,coins);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
// Time Complexity:O(2N), as each element has 2 choices, and there are N elements in the array.

// Space Complexity:O(N), the stack space will be O(N), the maximum depth of the stack.

//memoization
class Solution {
    public int f(int ind , int target,int[] coins,int[][] dp){
        if(ind == 0){
            if(target % coins[ind] == 0){
                return target / coins[ind];
            }else{
                return (int)1e9;
            }
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int notTake = 0 + f(ind-1,target,coins,dp);
        int take = (int)1e9;
        if(coins[ind] <= target){
            take = 1 + f(ind , target-coins[ind] , coins,dp);
        }
        return dp[ind][target] =  Math.min(take , notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans =  f(n-1,amount,coins,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
//time - > O( n * amount)
//space -> O( n * amount) + O(n)

//tabulation

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int i = 0 ; i <= amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake = 0 + dp[i-1][t];
                int take = (int)1e9;
                if(coins[i] <= t){
                     take = 1 + dp[i][t-coins[i]];
                }
                dp[i][t] =  Math.min(take , notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >= (int)1e9){
            return -1;
        }else{
            return dp[n-1][amount];
        }
    }
}
//time -> O( n * target)
//space -> O ( n * target)

