/*
Question Link: https://practice.geeksforgeeks.org/problems/remove-duplicates3034/0/?track=md-string&batchId=144
Approach: Used a boolean array to keep track of earlier occurence of characters of array.
*/
class Solution {
    String removeDups(String S) {
        StringBuilder sb = new StringBuilder();
        boolean[] exists = new boolean[26];
        for(int i=0; i<S.length(); i++){
            char curr = S.charAt(i);
            int currIndex;
            if(curr>='A' && curr<='Z')
                currIndex=curr-65;
            else
                currIndex=curr-97;
            if(!exists[currIndex])
                sb.append(curr);
            exists[currIndex]=true;
        }
        return sb.toString();
    }
}