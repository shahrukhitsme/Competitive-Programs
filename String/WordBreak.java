/*
Question Link: https://leetcode.com/problems/word-break/
Approach: Traverse through list of words, and check if it exists in the string, and do the same for the remaining part(s) of the word using recursion and dp.
*/
class Solution {
    HashMap<String, Boolean> possible = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return true;
        if(possible.containsKey(s))
            return possible.get(s);
        for(String word: wordDict){
            int k = s.indexOf(word);
            if(k!=-1){
                if(wordBreak(s.substring(0, k), wordDict) & wordBreak(s.substring(k+word.length(), s.length()), wordDict)){
                    possible.put(s, true);
                    return true;
                }
            }
        }
        possible.put(s, false);
        return false;
    }
}