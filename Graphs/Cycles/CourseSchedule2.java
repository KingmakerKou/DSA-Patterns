class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
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
    if(list.size() == V){
            int[] res = new int[list.size()];
            for(int i=0;i<list.size();i++){
                res[i] = list.get(i);
            }
            return res;
        }
    return new int[]{};
    }
}
