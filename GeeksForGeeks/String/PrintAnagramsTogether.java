/*
Question Link: https://practice.geeksforgeeks.org/problems/print-anagrams-together/1
Approach: For each string created another string having counts of each alphabet in alphabetical order such that the resultant string is same for anagrams, and stored them as key
in a hashmap with value pointing to a list having indices of array having the string which is the source of that resultant string, hence clubbing all anagrams together. Then just 
stored them in an array.
*/
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<string_list.length; i++){
            StringBuilder sb = new StringBuilder();
            HashMap<Character, Integer> mp = new HashMap<>();
            String s = string_list[i];
            for(int j=0; j<s.length(); j++)
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
            for(char j='a'; j<='z'; j++){
                sb.append(mp.getOrDefault(j, 0));
                sb.append("-");
            }
            for(char j='A'; j<='Z'; j++){
                sb.append(mp.getOrDefault(j, 0));
                sb.append("-");
            }
            String str = sb.toString();
            if(!map.containsKey(str)){
                List<Integer> l = new ArrayList<>();
                map.put(str, l);
            }
            map.get(str).add(i);
        }
        for(String key : map.keySet()){
            List<Integer> ls = map.get(key);
            List<String> innerList = new ArrayList<>();
            for(int i=0; i<ls.size(); i++){
                innerList.add(string_list[ls.get(i)]);
            }
            res.add(innerList);
        }
        return res;
    }
}