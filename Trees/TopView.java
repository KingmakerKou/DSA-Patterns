/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair{
    Node node;
    int line;
    Pair(Node node , int line){
        this.node = node;
        this.line = line;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        TreeMap<Integer , Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root , 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node n = p.node;
            int line = p.line;
            
            if(!mpp.containsKey(line)){
                mpp.put(line , n.data);
            }
            
            if(n.left != null){
                q.offer(new Pair(n.left , line - 1));
            }
            if(n.right != null){
                q.offer(new Pair(n.right , line + 1 ));
            }
        }
        
        for(Integer it : mpp.values()){
            arr.add(it);
        }
    return arr;
    }
}

