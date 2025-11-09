//DFS solution

class Solution {
    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj,int[] vis,int parent){
        vis[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(vis[neighbor] == 0){
                if(dfs(neighbor , adj , vis,node)){
                    return true;
                }
            }else if(neighbor != parent){
                return true;
            }
        }
    return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        //we will be doing this with DFS algo
        
        //first create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        //create visited arr
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i,adj,vis,-1)){
                    return true;
                }
            }
        }
    return false;
    }

//   Time Complexity: O(V + E)
// (where V is the number of nodes and E is the number of edges in the graph)
// Traversing the complete graph overall which taken O(V+E) time.

// Space Complexity: O(V)
// Visited array takes O(V) space and in the worst case recursion stack will store O(V) calls taking O(V) space.
}
