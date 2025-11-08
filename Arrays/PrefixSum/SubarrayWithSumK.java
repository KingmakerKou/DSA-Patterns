class Solution {
    public int subarraySum(int[] nums, int k) {
        // we will be using prefix sum concept here ... use hasmap to store (prefix sum , count) 
        Map<Integer , Integer> mpp = new HashMap<>();
        int sum = 0 , cnt = 0;
        mpp.put(0 , 1);
        for(int num : nums){
            sum += num;
            if(mpp.containsKey(sum - k)){
                cnt += mpp.get(sum - k);
            }

            mpp.put(sum , mpp.getOrDefault(sum , 0) + 1);
        }
    return cnt;
    }
}
