//recursion
class Solution {
    public int f(int row , int col,int[][] grid){
        if(row>=0 && col>=0 && grid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col  < 0 ) return 0;
        int up = f(row-1,col,grid);
        int left = f(row,col-1,grid);
        return up + left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length; //no of rows
        int m = grid[0].length; //no  of columns
        return f(n-1,m-1,grid);
    }
}
// Time Complexity: O(2(M+N)*(M+N)), where M is the number of row and N is the number of column in 2D array. As, each cell 
//has 2 choices and path length is near about (M+N) and each path would take (M+N) to travel as well.

// Space Complexity:O((M-1)+(N-1)), In the worst case, the depth of the recursion can reach (M-1)+(N-1), corresponding to the maximum number of steps required to reduce both i and j to 0.

//memoization
class Solution {
    public int f(int row , int col,int[][] grid,int[][] dp){
        if(row>=0 && col>=0 && grid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col  < 0 ) return 0;
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = f(row-1,col,grid,dp);
        int left = f(row,col-1,grid,dp);
        return dp[row][col]= up + left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length; //no of rows
        int m = grid[0].length; //no  of columns
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,grid,dp);
    }
}
// Time Complexity: O(M*N), where M is the number of row and N is the number of column in 2D array. At max, there will be M*N calls of recursion as the subproblems can go upto M*N.

// Space Complexity:O((N-1)+(M-1)) + O(M*N), We are using a recursion stack space: O((N-1)+(M-1)), here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.

//tabulation
class Solution {
    public int f(int row , int col,int[][] grid,int[][] dp){
        if(row>=0 && col>=0 && grid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col  < 0 ) return 0;
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = f(row-1,col,grid,dp);
        int left = f(row,col-1,grid,dp);
        return dp[row][col]= up + left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length; //no of rows
        int m = grid[0].length; //no  of columns
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }else{
                    int up = 0 , left = 0;
                    
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    if(j > 0){
                        left = dp[i][j-1];
                    }
                dp[i][j] = up + left;
                }
            }
        }
    return dp[n-1][m-1];
    }
}
