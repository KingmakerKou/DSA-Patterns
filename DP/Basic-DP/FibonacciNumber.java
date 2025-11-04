//recursion

//1.memoization
class Solution {
    private int f(int n , int[] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] =  f(n-1,dp) + f(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return f(n , dp);
    }
}

//time - > O(n)
//space - > O(h) + O(n)

//2.tabulation
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0; 
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
    return dp[n];
    }
}

//time : O(N)
//space : O(N)

//3.space optimization
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int prev2 = 0; 
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }
    return prev;
    }
}

//time : O(N)
//space : O(1)
