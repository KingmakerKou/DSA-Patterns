class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        int i = 0 , n = intervals.length;
        List<int[]> arr = new ArrayList<>();
        while( i < n){
            //add all intervals that ends before our new interval start
            while( i < n && intervals[i][1] < newInterval[0]){
                arr.add(intervals[i]);
                i++;
            }
            //merging overlapping intervals
            while(i < n && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1] , newInterval[1]);
                i++;
            }
            arr.add(newInterval);
            //after merging add remianing
            while(i < n){
                arr.add(intervals[i]);
                i++;
            }
        }
    return arr.toArray(new int[arr.size()][]);
    }
}
