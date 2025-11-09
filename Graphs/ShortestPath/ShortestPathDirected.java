// User function Template for Java
class Pair{
    int first , second;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(Pair it : adj.get(i)){
                int v = it.first;
                indegree[v]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(Pair it : adj.get(node)){
                int f = it.first;
                indegree[f]--;
                
                if(indegree[f] == 0) q.offer(f);
            }
        }
        
        //create a distance arr
        int[] dist = new int[V];
        final int INF = (int)1e9;
        Arrays.fill(dist,INF);
        dist[0]=0;
        
        for(int it : topo){
            if(dist[it] == INF) continue;
            for(Pair p : adj.get(it)){
                int v = p.first;
                int weight = p.second;
            
                if(dist[it] + weight < dist[v]){
                    dist[v] = dist[it] + weight;
                }
            }
            
        }
        
        for(int i=0;i<V;i++){
            if(dist[i] == INF) dist[i] = -1;
        }
        
    return dist;
        
    }
}


//Time Complexity: O(N+M)

// Topological Sorting takes O(N+M) time.
// To relax all the vertices, each node and its adjacent nodes are traversed taking O(M) time.
// Space Complexity: O(N+M)

// Storing the graph takes O(M) space.
// The stack storing the topological ordering takes O(N) space.
// The topological sorting algorithm uses O(N) space due to visited array and recursion stack space.
