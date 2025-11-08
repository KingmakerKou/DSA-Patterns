// optimized linear bucket sort version
//time : O ( n )
//space : O(n) + O(n) + O(k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //create buckets
        List<Integer>[] bucket = new List[nums.length + 1];
        //create hashmap
        Map<Integer , Integer> mpp = new HashMap<>();

        //traverse the number
        for(int num : nums){
            mpp.put(num , mpp.getOrDefault(num,0) + 1);
        }

        //add the no to the freq bucket
        for(int key : mpp.keySet()){
            int freq = mpp.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        //traverse the freq bucket from last for k times
        int[] res = new int[k];
        int counter = 0;
        for(int i=bucket.length-1;i>=0 && counter < k;i--){
            if(bucket[i] != null){
                for(Integer integer : bucket[i]){
                    res[counter++] = integer;
                }
            }
        }
    return  res;
    }
}
