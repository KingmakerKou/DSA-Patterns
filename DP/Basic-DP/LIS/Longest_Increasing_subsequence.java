//recursion
class Solution {
    public int f(int ind , int prev_ind , int[] nums , int n){
        if(ind == n) return 0;

        int not_take = f(ind+1 , prev_ind , nums , n);

        int take = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            take = 1 + f(ind+1 , ind , nums , n);
        }
        int len = Math.max(not_take , take);
    return len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return f(0,-1,nums,n);
    }
}
//time - > O(2^N)
//space -> O(N)

//memoization

class Solution {
    public int f(int ind , int prev_ind , int[] nums , int n,int[][] dp){
        if(ind == n) return 0;
        if(dp[ind][prev_ind+1] != -1){
            return dp[ind][prev_ind+1];
        }
        int not_take = f(ind+1 , prev_ind , nums , n,dp);

        int take = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            take = 1 + f(ind+1 , ind , nums , n,dp);
        }
        return dp[ind][prev_ind+1] = Math.max(not_take , take);
    
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(0,-1,nums,n,dp);
    }
}
// Time Complexity: O(N2), where N is the size of the array
// Because there will be a total of N*N states for which the function will be called.

// Space Complexity: O(N2), because of the 2D dp array created taking O(N2) space and O(N) recursive stack space.



//optimzed --> definetely a binary search solution


class Solution {
    public int lowerbound(int target , List<Integer> list){
        int low = 0 , high = list.size()-1 , ans = list.size();
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
    return ans;

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int ind = lowerbound(nums[i],list);
                list.set(ind , nums[i]);
            }

        }
    return list.size();
    }
}
