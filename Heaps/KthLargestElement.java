// brute is to sort and find kth element
//better is to maintain the size of K in prioirty Queue and then traverse from k and remove min element and add nums[i] if it's greater than peek
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;

        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }

        for(int i=k;i<n;i++){
            if(nums[i] > pq.peek()){
                pq.poll();

                pq.add(nums[i]);
            }
        }
    return pq.peek();
    }
}
