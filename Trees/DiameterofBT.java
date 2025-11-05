// Leetcode: Diameter of Binary Tree
// Time Complexity: O(N)

class Solution {
    int maxi = 0;

    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        // Track maximum diameter found so far
        maxi = Math.max(maxi, lh + rh);

        // Return height of current node
        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }
}
