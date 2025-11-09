class Solution {
    public void bfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] vis ,ArrayList<Integer> res ){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        
        while(!q.isEmpty()){
            int n = q.poll();
            res.add(n);
            
            for(int neighbor : adj.get(n)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        //find vertices
        int V = adj.size();
        //create a visited array
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                bfs(i,adj,vis,res);
            }
        }
    return res;        
    }
}

//Time Complexity: O(V+E) (where E represents the number of edges in the graph)
//All the V nodes are traversed during the traversal and all the E edges are processed once taking an overall time complexity of O(V+E).

//Space Complexity: O(V)
//The BFS traversal uses a queue data structure to process the nodes in a level-order fashion. In the worst case, all the nodes will be present in the queue leading to space requirement of O(V).
