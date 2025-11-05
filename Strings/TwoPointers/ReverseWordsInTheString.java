//brtue force solution
//time - > O(N)
//space -> O(N)
class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int i = 0;
        List<String> mpp = new ArrayList<>();
        while(i < n){
            while(i < n && s.charAt(i) == ' ') i++;
            if(i >= n) break;
            int start = i;
            while(i < n && s.charAt(i) != ' ') i++;
            int end = i-1;

            String word = s.substring(start,end+1);
            mpp.add(word);
        }
        StringBuilder str = new StringBuilder();
        for(int j=mpp.size()-1;j>=0;j--){
            str.append(mpp.get(j));

            if(j != 0){
                str.append(' ');
            }
        }
    return str.toString();
    }
}
