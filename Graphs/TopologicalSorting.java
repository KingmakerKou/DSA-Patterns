import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        //first create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int y = edges.get(i).get(1);

            adj.get(u).add(y);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        //adding indegree 
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
    return ans;
    }
}


//Time Complexity: O(V+E) (where V and E represent the number of nodes and edges in the graph)
//A simple BFS traversal takes O(V+E) time.

    // Space Complexity: O(V)
    // Array to store in-degrees require O(V) space and queue space will store O(V) nodes at maximum.
