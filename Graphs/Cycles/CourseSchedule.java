// in order to take one course a , b
// a must occur before b
//so it maps to topological sort where there should be linear ordering of edges (u,v ) ..u must always occur before v
//if can we write topo sort for this .. then yes we can finish the courees
class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }

        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0) q.offer(it);
            }
        }
    return list.size() == V;
    }
}
