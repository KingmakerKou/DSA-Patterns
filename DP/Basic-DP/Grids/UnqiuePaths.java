//recursion
class Solution {
    public int f(int row , int col){
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;
        int up = f(row-1,col);
        int left = f(row,col-1);
        return up + left;
    }
    public int uniquePaths(int m, int n) {
        return f(m-1,n-1);
    }
}

//memoization
class Solution {
    public int f(int row , int col,int[][] dp){
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = f(row-1,col,dp);
        int left = f(row,col-1,dp);
        return dp[row][col] =  up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp);
    }
}

//tabulation
class Solution {
    public int f(int row , int col,int[][] dp){
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = f(row-1,col,dp);
        int left = f(row,col-1,dp);
        return dp[row][col] =  up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                else{
                    int up = 0;
                    int down = 0;
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    if(j > 0){
                        down = dp[i][j-1];
                    }

                    dp[i][j] = up + down;
                }
            }
        }
    return dp[m-1][n-1];
    }
}
