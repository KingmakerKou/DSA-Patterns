class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        if(start.length == 0){
            return 0;
        }
        List<int[]> meetings = new ArrayList<>();
        
        for(int i=0;i<start.length;i++){
            meetings.add(new int[]{start[i] , end[i]});
        }
        
        Collections.sort(meetings , Comparator.comparingInt(i -> i[1]));
        
        int cnt = 1;
        int freetime = meetings.get(0)[1];
        for(int i=1;i<meetings.size();i++){
            if(meetings.get(i)[0] > freetime){
                cnt++;
                freetime = meetings.get(i)[1];
            }
        }
    return cnt;
    }
}


Time : O(nlogn)
space : O(n)
