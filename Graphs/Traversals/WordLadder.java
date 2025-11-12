//they will give us the start word and they will give us the end word .. return the shortest transformation steps from start word to the end word

//take one word and try to replace every characters with all possbile 26 alphabets
//go level by level --> so thats y it comes under BFS
class Pair{
    String str;
    int steps;
    Pair(String str , int steps){
        this.str = str;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        q.offer(new Pair(beginWord , 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.str;
            int steps = p.steps;

            if(word.equals(endWord)) return steps;

            char[] arr = word.toCharArray();
            for(int i = 0 ; i < arr.length ; i++){
                char orginal = arr[i];

                for(char j = 'a' ; j<='z' ;j++){
                    arr[i] = j;
                    String newword = new String(arr);

                    if(set.contains(newword)){
                        q.offer(new Pair(newword , steps + 1));
                        set.remove(newword);
                    }
                }
            arr[i] = orginal;
            }
        }
    return 0;
    }
}
//Time Complexity: O(N*M*26)

//In the worst case, the steps required to reach from startWord to targetWord can go up to N. During each step, all the characters for the word are replaced from 'a' to 'z' taking O(M*26) time.
// Adding all the words in wordList takes O(N) time.
// Note: If an ordered set is used in place of an unordered set then there will be a logN factor adding to the time complexity, since delete and update operations take O(logN) time for the ordered set.



// Space Complexity: O(N)
// A Hashset is used to store words in wordList taking O(N) space.



