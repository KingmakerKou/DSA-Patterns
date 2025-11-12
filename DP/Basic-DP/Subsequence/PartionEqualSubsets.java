// partition array to equal subsets having equal sum
//map this to equal subarray equals K problem

//if odd sum we cant divide to equal -->return false
//if even --> each subset should have target sum (total_sum / 2)

//recursion
class Solution {
    private boolean f(int ind , int target , int[] nums){
        if(target == 0){
            return true;
        }
        if(ind == 0) return (nums[ind] == target);
        boolean notake = f(ind - 1 , target ,nums);
        boolean take = false;
        if(nums[ind] <= target){
            take = f(ind -1 , target - nums[ind] , nums);
        }
        return notake || take;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum  % 2 == 1) return false;
        return f(n-1 , sum/2 , nums);

    }
}

//memoization


