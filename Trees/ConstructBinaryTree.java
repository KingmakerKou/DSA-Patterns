//construct binary tree from preorder and inorder
class Solution {
    public TreeNode buildtree(int[] preorder , int pstart , int pend , int[] inorder , int istart , int iend , Map<Integer , Integer> mpp){
        if(pstart > pend || istart > iend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootind = mpp.get(root.val);
        int numsleft = rootind - istart;
        root.left = buildtree(preorder , pstart+1 , pstart+numsleft , inorder , istart , rootind - 1 , mpp);
        root.right = buildtree(preorder , pstart+numsleft + 1 , pend , inorder , rootind + 1 , iend , mpp);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer , Integer > mpp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i] , i);
        }
        return buildtree(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1 , mpp);
    }
}
//time - > O(N)
//space => O(n) + O(h)

// construct binary tree from inorder and postorder
class Solution {
    public TreeNode buildtree(int[] postorder , int pstart , int pend , int[] inorder , int istart , int iend , Map<Integer,Integer> mpp){
        if(pstart > pend || istart > iend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int rootind = mpp.get(root.val);
        int numsleft = rootind - istart;

        root.left = buildtree(postorder , pstart, pstart+numsleft-1 , inorder , istart , rootind-1 , mpp);
        root.right = buildtree(postorder , pstart+numsleft , pend-1 , inorder , rootind+1 , iend , mpp);
    return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer , Integer> mpp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i] , i);
        }
        return buildtree(postorder , 0 , postorder.length-1 , inorder , 0 , inorder.length-1 , mpp);
    }
}
