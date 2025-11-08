//brute force
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> mpp = new HashMap<>();

        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = Arrays.toString(temp);

            if(!mpp.containsKey(key)){
                mpp.put(key , new ArrayList<>());
            }
            mpp.get(key).add(str);

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String , List<String>> map : mpp.entrySet()){
            res.add(map.getValue());
        }
    return res;
    }
}

//optmised
    // find the frequency of each string instead of sorting them
    //time -> O(k . n)
    //space -> O(k . n)
class Solution {
    public String FindFreq(String str){
        int[] hash = new int[26];
        for(char ch : str.toCharArray()){
            hash[ch - 'a']++;
        }

        StringBuilder strr = new StringBuilder();
        char c = 'a';
        for(int i : hash){
            strr.append(c);
            strr.append(i);
            c++;
        }
    return strr.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        int n = strs.length;
        Map<String , List<String>> mpp = new HashMap<>();

        for(int i=0;i<n;i++){
            String freq = FindFreq(strs[i]);

            if(mpp.containsKey(freq)){
                mpp.get(freq).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                mpp.put(freq , temp);
            }
           
        }
    return new ArrayList<>(mpp.values());
    }
}
