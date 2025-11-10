//recursion solution
class Solution {
    static boolean f(int ind , int target,int[] arr){
        if(target == 0) return true;
        if(ind == 0) return (arr[0] == target);
        
        boolean not_take = f(ind-1 , target , arr);
        boolean take = false;
        if(arr[ind] <= target){
            take = f(ind-1,target-arr[0],arr);
        }
        
        return take || not_take;
            
        
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        return f(n-1,sum,arr);
        
    }
}


//memoization

class Solution {
    static boolean f(int ind , int target,int[] arr,int[][] dp){
        
        if(target == 0) return true;
        if(ind == 0) return (arr[0] == target);
        
        if(dp[ind][target] != -1){
            return dp[ind][target] == 0 ? false : true;
        }
        
        boolean not_take = f(ind-1 , target , arr,dp);
        boolean take = false;
        if(arr[ind] <= target){
            take = f(ind-1,target-arr[ind],arr,dp);
        }
        
        dp[ind][target]  = (take || not_take) ? 1 : 0;
        return (take || not_take);
            
        
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][sum+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,sum,arr,dp);
        
    }
}

//tabulation
class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        if(sum == 0) return true;
        boolean[][] dp = new boolean[n][sum+1];
        
        //1st base case if target == 0
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        
        
        for(int ind=1;ind<n;ind++){
            for(int i = 1 ; i <= sum;i++){
                boolean not_take = dp[ind-1][i];
                boolean take = false;
                if(arr[ind] <= i){
                    take = dp[ind-1][i-arr[ind]];
                }
                
                dp[ind][i] = (take || not_take);
                
            }
        }
    return dp[n-1][sum];
        
    }
}
