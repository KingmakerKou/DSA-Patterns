class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] vis = new boolean[n];
        int current_level = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<String , Integer> mpp = new HashMap<>();
        vis[id] = true;
        q.offer(id);

        //going to that level k 
        while(!q.isEmpty()){
            int size = q.size();

            if(current_level == level) break;

            for(int i=0;i<size;i++){
                int node = q.poll();

                for(int it : friends[node]){
                    if(!vis[it]){
                        vis[it] = true;
                        q.offer(it);
                    }
                }
            }
            current_level++;
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(String s : watchedVideos.get(node)){
                mpp.put(s , mpp.getOrDefault(s , 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(mpp.keySet());
        list.sort((a,b) -> {
            int fe = mpp.get(a);
            int se = mpp.get(b);
            if(fe != se) return fe - se;
            return a.compareTo(b);
        });
    return list;
    }
}
