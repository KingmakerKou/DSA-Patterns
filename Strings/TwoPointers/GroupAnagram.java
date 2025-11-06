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
