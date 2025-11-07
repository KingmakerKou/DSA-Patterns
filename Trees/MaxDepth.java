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
    int maxi = 0;
    public int depth(TreeNode root){
        if(root == null) return 0;
        int lh = depth(root.left);
        int rh = depth(root.right);
        maxi = Math.max(lh , rh) + 1;
        return maxi;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root);
    }
}

//time -> O(n)
//space --> O(h)
