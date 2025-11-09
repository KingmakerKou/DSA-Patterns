class Solution {
    public int[] bfs(int src ,ArrayList<ArrayList<Integer>> adj , int[] dist){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.offer(it);
                }
            }
        }
    return dist;
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        
        int V = adj.size(); //no of vertices
        
        int[] dist = new int[V];
        final int INF = (int)1e9;
        Arrays.fill(dist,INF);
        dist[src]=0;
        
        bfs(src,adj,dist);
        
        for(int i=0;i<V;i++){
            if(dist[i] == INF){
                dist[i] = -1;
            }
        }
        
    return dist;
        
    }
}

//Time Complexity: O(N+M)

// Creating the graph takes O(M) time.
// BFS traversal of graph takes O(N+M) time.
// Updating distance of unreachable node takes O(N) time.
// Space Complexity: O(N+M)

// Storing the graph requires O(M) space.
// Visited array takes O(N) space.
// The queue space taken during BFS traversal will be O(N) in worst case.
