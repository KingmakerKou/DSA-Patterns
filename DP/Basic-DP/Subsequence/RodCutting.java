// we have to find the maximum amount we can have by cutting the rod and selling the pieces
//so we can turn this into .. pick up the length of rods and sum it up to the N and find the maximum from that

//recursion
class Solution {
    private int f(int ind  , int n , int[] price){
        if(ind ==0){
            return n*price[0];
        }
        int notake = f(ind - 1 , n ,  price);
        int take = Integer.MIN_VALUE;
        int rod_length = ind + 1;
        if(rod_length <= n){
            take =  price[ind] + f(ind , n-rod_length , price);
        }
        return Math.max(take , notake);
    }
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        return f(n - 1 , n , price);

    }
}
//time -> exponential

//memoization
class Solution {
    private int f(int ind  , int n , int[] price,int[][] dp){
        if(ind ==0){
            return n*price[0];
        }
        if(dp[ind][n] != -1){
            return dp[ind][n];
        }
        int notake = f(ind - 1 , n ,  price , dp);
        int take = Integer.MIN_VALUE;
        int rod_length = ind + 1;
        if(rod_length <= n){
            take =  price[ind] + f(ind , n-rod_length , price , dp);
        }
        return dp[ind][n] = Math.max(take , notake);
    }
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return f(n - 1 , n , price,dp);

    }
}
//time -> O(n * rod_length)
//space -> O ( n * rod_length)

//tabulation
class Solution {

    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        
        for(int i=0;i<=n;i++){
            dp[0][i] = i*price[0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int notake = dp[i - 1 ][j];
                int take = Integer.MIN_VALUE;
                int rod_length = i + 1;
                if(rod_length <= j){
                    take =  price[i] + dp[i][j-rod_length];
                }
            dp[i][j] = Math.max(take , notake);
            }
        }
    return dp[n-1][n];
    }
}
//time - > O(n * rodlength)
//soace --> O(n * rodlength)

