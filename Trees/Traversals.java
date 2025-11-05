//BINARY TREES
//1.Inorder ( left --> root ---> right)
class Solution {
    private void inorder(TreeNode root , List<Integer> arr){
            if(root == null){
                return;
            }
            inorder(root.left,arr);
            arr.add(root.val);
            inorder(root.right,arr);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        return arr;
    }
}
//Time Complexity O(N) where n is the number of nodes in the tree due to traversal of each node once

//SpaceComplexity O(h) where h is the height of the tree for the recursion stack, plus O(n) for the output array

//2.PreOrder(root --> left -->right)
class Solution {
    public void preorder(TreeNode root , List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
}
//Time Complexity O(N) where n is the number of nodes in the tree due to traversal of each node once

//SpaceComplexity O(h) where h is the height of the tree for the recursion stack, plus O(n) for the output array

//3.PostOrder
class Solution {
    private void postorder(TreeNode root , List<Integer> arr){
        if(root == null) return;
        postorder(root.left,arr);
        postorder(root.right,arr);
        arr.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        postorder(root,arr);
        return arr;
    }
}
//Time Complexity O(N) where n is the number of nodes in the tree due to traversal of each node once

//SpaceComplexity O(h) where h is the height of the tree for the recursion stack, plus O(n) for the output array

//4.Level order of the Binary Tree
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                ans.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(ans);
        }
    return res;
    }
}
//Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once,
//                 hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.
//Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree;
//                  the last level could at most hold N/2 nodes, hence the space complexity of the queue is proportional to O(N). 
//                  The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.


//5. Zig-Zag Level Order Traversal
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>(Collections.nCopies(size,0));
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int index = leftToRight ? i : (size-i-1);
                arr.set(index,node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(arr);
        }
    return res;
    }
}
//Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited.

//Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree, 
//the last level could at most hold N/2 nodes hence the space complexity of the queue is proportional to O(N).

//6.Boundary Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    private boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null){
            return  true;
        }
    return false;
    }
    private void addLeftBoundary(TreeNode curr , List<Integer> res){
        while(curr != null){
            if(isLeaf(curr) == false){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
    }

    private void addLeaves(TreeNode node , List<Integer> res){
            if(node == null) return;
            if(isLeaf(node)){
                res.add(node.data);
                return;
            }
            addLeaves(node.left,res);
            addLeaves(node.right,res);
    }
    private void addRightBoundary(TreeNode curr , List<Integer> res){
        List<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr) == false){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }


    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(!isLeaf(root)){
            res.add(root.data);
        }
        addLeftBoundary(root.left , res);
        addLeaves(root , res);
        addRightBoundary(root.right , res);
    return res;
    }
}
//time -> O(n)
//space -> O(h)





