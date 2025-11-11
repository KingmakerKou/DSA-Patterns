// find the maximum or minimum path sum in the grid .. it can start from any cell and end at any cell

//recursion
class Solution {
    private int f(int row , int col , int[][] matrix , int n , int m){
        if(col < 0 || col >= m) return (int)1e9;
        if(row == 0) return matrix[0][col];

        int s = matrix[row][col] + f(row - 1 , col , matrix , n , m);
        int ld = matrix[row][col] + f(row - 1 , col - 1 , matrix , n , m);
        int rd = matrix[row][col] + f(row - 1 , col + 1 , matrix , n , m);

        return Math.min(s , Math.min(ld,rd));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; //rows
        int m = matrix[0].length; //columns
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            int ans = f(n-1,i,matrix,n,m);
            mini = Math.min(mini,ans);
        }
    return mini;
    }
}
//time -> O(3^N)
//space -> O(N)


//memoization

class Solution {
    private int f(int row , int col , int[][] matrix , int n , int m,int[][]dp){
        if(col < 0 || col >= m) return (int)1e9;
        if(row == 0) return matrix[0][col];
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int s = matrix[row][col] + f(row - 1 , col , matrix , n , m,dp);
        int ld = matrix[row][col] + f(row - 1 , col - 1 , matrix , n , m,dp);
        int rd = matrix[row][col] + f(row - 1 , col + 1 , matrix , n , m,dp);

        return dp[row][col] =  Math.min(s , Math.min(ld,rd));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; //rows
        int m = matrix[0].length; //columns
        int mini = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];

        for(int i=0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int s = matrix[i][j] + dp[i - 1][j];
                int ld = Integer.MAX_VALUE / 2;
                if(j - 1 >= 0){
                    ld = matrix[i][j] +  dp[i - 1][j - 1];
                }
                int rd = Integer.MAX_VALUE / 2;
                if(j + 1 < m){
                    rd = matrix[i][j] +  dp[i - 1][j + 1];

                }
                dp[i][j] =  Math.min(s , Math.min(ld,rd));
            }
        }
        for(int i=0;i<m;i++){
            mini = Math.min(mini , dp[n-1][i]);
        }
    return mini;
    }
}

//time -> O ( n * M)
//space  -> O( n * m)
