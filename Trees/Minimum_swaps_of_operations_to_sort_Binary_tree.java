/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int minimumSwaps(int[] arr){
        int swap = 0;
        int[] sorted = Arrays.copyOf(arr , arr.length);
        Arrays.sort(sorted);

        Map<Integer , Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            mpp.put(arr[i] , i);
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != sorted[i]){
                int correctInd = mpp.get(sorted[i]);

                int temp = arr[i];
                arr[i] = arr[correctInd];
                arr[correctInd] = temp;

                mpp.put(temp , correctInd);
                mpp.put(arr[i], i);

                swap++;
            }

        }
    return swap;
    }
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int swaps = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int[] arr = new int[size];

            for(int i=0;i<size;i++){
                TreeNode no = q.poll();
                arr[i] = no.val;

                if(no.left != null){
                    q.offer(no.left);
                }
                if(no.right != null){
                    q.offer(no.right);
                }
            }

            swaps += minimumSwaps(arr);
        }
    return swaps;
    }
}
