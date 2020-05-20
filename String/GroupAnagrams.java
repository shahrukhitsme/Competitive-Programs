/*
Question Link: https://leetcode.com/problems/group-anagrams/
Approach: Create freqArr for each string and convert it into a string to be used as a key for a hashmap.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp;
        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String key = getHash(strs[i]);
            if(mp.containsKey(key))
                mp.get(key).add(strs[i]);
            else{
                temp = new ArrayList<>();
                temp.add(strs[i]);
                mp.put(key, temp);
            }
        }
        for(String key: mp.keySet())
            res.add(mp.get(key));
        return res;
    }
    
    public String getHash(String str){
        int[] freqArr = new int[26];
        for(int i=0; i<str.length(); i++){
            int index = str.charAt(i)-97;
            freqArr[index]++;
        }
        return Arrays.toString(freqArr);
    }
}