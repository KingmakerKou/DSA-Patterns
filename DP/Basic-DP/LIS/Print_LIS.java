// to print the LIS .. we will use the diff tabulation approach not the binary search ones
class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp , 1);
        
        int maxi = 0;
        int lastIndex = 0;
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            for(int prev = 0 ; prev < i ; prev++){
                if(arr[i] > arr[prev] && dp[i] < dp[prev] + 1){
                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
                
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex= i;
            }
        }
        
        int i = lastIndex;
        ArrayList<Integer> list = new ArrayList<>();
        while(parent[i] != i){
            list.add(arr[i]);
            i = parent[i];
        }
        list.add(arr[i]);
        Collections.reverse(list);
        
    return list;
    }
}
