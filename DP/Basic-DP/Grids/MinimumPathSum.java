class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] sum = new int[n][m];
        sum[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int j=1;j<m;j++){
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                sum[i][j] = grid[i][j] +  Math.min(sum[i-1][j] , sum[i][j-1]);
            }
        }
    return sum[n-1][m-1];
    }
}
