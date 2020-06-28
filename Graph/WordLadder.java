/*
Question Link: https://leetcode.com/problems/word-ladder/
Approach: Change each letter, of current word to every other letter one by one, and if it is present in wordlist it means they are direct neighbours, and add 1 to distance. Keep doing this, until you find the endWord. This is a slight variation of BFS.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> unreached = new HashSet<>();
        for(int i=0; i<wordList.size(); i++)
            unreached.add(wordList.get(i));
        if(!unreached.contains(endWord))
            return 0;
        unreached.add(endWord);
        HashSet<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while(!reached.contains(endWord)){
            HashSet<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for(int i=0; i<each.length(); i++){
                    char[] ch = each.toCharArray();
                    for(char c='a'; c<='z'; c++){
                        ch[i]=c;
                        String str = String.valueOf(ch);
                        if(unreached.contains(str)){
                            unreached.remove(str);
                            toAdd.add(str);
                        }
                    }
                }
            }
            distance++;
            if(toAdd.size()==0)
                return 0;
            reached = toAdd;
        }
        return distance;
    }
}