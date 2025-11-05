 */
class Solution {
    public int check(TreeNode root){
        if(root == null) return 0;
        int lh = check(root.left);
        int rh = check(root.right);

        if(lh == -1 || rh == -1){
            return -1;
        }

        if(Math.abs(lh-rh) > 1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        //uses the height of the binary tree logic...
        return check(root)!=-1;
    }
}

//using the height of the binary tree solution we will compute the balanced checking
//if the lh - rh > 1 we return -1...
