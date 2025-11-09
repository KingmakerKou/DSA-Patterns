//any nodes that has cycle or lead to cycle cant go to terminal node so it cant be a safe node
//using dfs to mark safe and unsafe nodes
class Solution {
    public boolean dfs(int node , List<List<Integer>> adj ,boolean[] vis,boolean[] pathvis,boolean[] checksafe){
        vis[node] = true;
        pathvis[node] = true;
        checksafe[node] = false;

        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(it,adj,vis,pathvis,checksafe)){
                    return true;
                }
            }else if(pathvis[it]){
                return true;
            }
        }
    checksafe[node] = true;
    pathvis[node] = false;
    return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }

        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        boolean[] checksafe = new boolean[V];   
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,pathvis,checksafe);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(checksafe[i]){
                ans.add(i);
            }
        }
    return ans;
    }
}
