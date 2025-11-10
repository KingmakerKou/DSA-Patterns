

//we will be given a weight and value and our bag weight ..we must steal maximum value products that doesnt exceed our bag weight
 //recursion
class Solution {
    public int f(int ind , int W , int[] val , int[] wt){
        if(ind == 0){
            if(wt[ind] <= W){
                return val[ind];
            }else{
                return 0;
            }
        }
        int notake = 0 + f(ind-1 , W , val , wt);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + f(ind-1 , W-wt[ind] , val , wt);
        }
        return Math.max(notake , take);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        return f(n-1,W, val,wt);
    }
}
// time - > O ( 2^N)
// space -> O( n )

//memoization

class Solution {
    public int f(int ind , int W , int[] val , int[] wt,int[][] dp){
        if(ind == 0){
            if(wt[ind] <= W){
                return val[ind];
            }else{
                return 0;
            }
        }
        if(dp[ind][W] != -1){
            return dp[ind][W];
        }
        int notake = 0 + f(ind-1 , W , val , wt,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + f(ind-1 , W-wt[ind] , val , wt,dp);
        }
        return dp[ind][W] =  Math.max(notake , take);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return f(n-1,W, val,wt,dp);
    }
}
// time - > O( n * W)
//space -> O( n * W)
//tabulation
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W+1];
        
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = val[0]; 
        }
        
        for(int i=1;i<n;i++){
            for(int amt = 0;amt<=W;amt++){
                int notake = dp[i-1][amt];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= amt){
                    take = val[i] + dp[i-1][amt-wt[i]];
                }
            dp[i][amt] =  Math.max(notake , take);
            }
        }
    return dp[n-1][W];
    }
}

