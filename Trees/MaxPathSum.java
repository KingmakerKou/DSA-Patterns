// Problem: Maximum Path Sum in a Binary Tree
// A path may start/end at any node and must follow parent-child links.
// Return the maximum possible sum of values along any path.

// Approach:
// For each node, compute the best downward gain from left and right.
// Ignore negative gains (they reduce the total).
// The best path passing through the node is leftGain + node.val + rightGain.
// Track a global max to store the answer.
// Return node.val + max(leftGain, rightGain) upward for parent use.

// Time Complexity: O(N)  - Each node visited once
// Space Complexity: O(H) - Recursion stack (H = tree height)

class Solution {

    int maxSum = Integer.MIN_VALUE; // global max path sum

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // compute best gain from left and right (ignore negatives)
        int left  = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // best path including this node as the highest point (turn)
        maxSum = Math.max(maxSum, left + right + root.val);

        // return best single chain upward
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}
