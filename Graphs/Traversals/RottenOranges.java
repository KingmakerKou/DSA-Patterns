class Pair{
    int first , second , time;
    Pair(int first , int second , int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxtime = 0;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int tme = p.time;
            maxtime = Math.max(maxtime,tme);
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                    q.offer(new Pair(nrow,ncol,tme+1));
                    vis[nrow][ncol] = 2;
                }
            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] != 2){
                    return -1;
                }
            }
        }
    return maxtime;
    }
}

//Time Complexity: O(N*M) (where N and M are the dimensions of grid)
//In the worst case, each fresh orange in the grid will be rotten and for each rotten orange, its 4 neighbors are checked taking O(4*N*M) time.

//Space Complexity: O(N*M)
//Using a queue data structure, which will store all cells if a grid is full of rotten oranges taking O(N*M) space.
