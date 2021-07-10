/*
Question Link: https://leetcode.com/problems/longest-string-chain/
Approach: Stored the strings in list of list based on their lengths. And started from seach string and moved to the next list of strings of length greater by 1, and checked which are successors, and recursively did the same for them. Also stored the answer for each string in a map to use for repeating sub problems.
*/
class Solution {
    HashMap<String, Integer> dp;
    public int longestStrChain(String[] words) {
        dp = new HashMap<>();
        List<List<String>> wList = new ArrayList<>();
        for(int i=0; i<18; i++){
            wList.add(new ArrayList<>());
        }
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int len = word.length();
            wList.get(len).add(word);
        }
        int max = 1;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int temp = getLen(word, wList);
            if(temp>max)
                max=temp;
        }
        return max;
    }
    
    public int getLen(String str, List<List<String>> wList){
        if(dp.containsKey(str))
            return dp.get(str);
        int len = str.length();
        if(wList.get(len+1).size()==0)
            return 1;
        int max = 0;
        List<String> words = wList.get(len+1);
        for(int i=0; i<words.size(); i++){
            String currWord = words.get(i);
            if(isRelated(str, currWord)){
                int temp = getLen(currWord, wList);
                if(temp>max)
                    max=temp;
            }
        }
        dp.put(str, max+1);
        return dp.get(str);
    }
    
    public boolean isRelated(String a, String b){
        if(b.length()!=a.length()+1)
            return false;
        boolean diff = false;
        int j=0;
        for(int i=0; i<a.length();i++){
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            if(ac!=bc && diff)
                return false;
            if(ac!=bc){
                diff = true;
                i--;
            }
            j++;
        }
        return true;
    }
}