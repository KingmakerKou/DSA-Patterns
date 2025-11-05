// Problem: Lowest Common Ancestor of two nodes in a Binary Tree (Not BST).
// Given two nodes p and q, return their lowest common ancestor.
// The LCA is the deepest node that has both p and q as descendants.

// Approach:
// - If the current node is null, return null.
// - If the current node matches p or q, return it (this node may be an ancestor).
// - Recursively search in left and right subtrees.
// - If both calls return non-null, current node is the LCA.
// - If only one side returns non-null, return that side.

// Time Complexity: O(N)      - Each node is visited once.
// Space Complexity: O(H)     - Recursion stack (H = height of tree).

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base cases
        if (root == null || root == p || root == q) 
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left & right return non-null → current node is LCA
        if (left != null && right != null)
            return root;

        // Otherwise return the non-null side
        return (left != null) ? left : right;
    }
}
