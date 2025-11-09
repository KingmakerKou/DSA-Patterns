class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> arr){
        vis[node] = true;
        arr.add(node);
        
        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                dfs(neighbor,adj,vis,arr);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V  = adj.size(); //no of vertices
        boolean[] vis = new boolean[V];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,arr);
            }
        }
    return arr;    
    }
}
//Time Complexity: O(V+E) (where E represents the number of edges in the graph)
//All the V nodes are traversed during the traversal and all the E edges are processed once taking an overall time complexity of O(V+E).

//Space Complexity: O(V)
//The DFS traversal uses a stack data structure or recursive stack space to process the nodes in a depth-first fashion. 
//In the worst case, all the nodes will be present in the stack leading to space requirement of O(V).
