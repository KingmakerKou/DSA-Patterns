// User function Template for Java

class Solution {
    void dfs(int row , int col , int[][]grid , int[][]vis ,ArrayList<String> list , int row0 , int col0){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        list.add(toString(row-row0,col-col0));
        int[] drow = {-1,0,1,0};
        int[] dcol =  {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow >= 0 && nrow<n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol]==0){
                dfs(nrow,ncol,grid,vis,list,row0,col0);
            }
        }
    }
    String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,grid,vis,list,i,j);
                    set.add(list);
                }
            }
        }
    return set.size();
    }
}


//time - > O ( n * m)
//space -> O( n * m )
