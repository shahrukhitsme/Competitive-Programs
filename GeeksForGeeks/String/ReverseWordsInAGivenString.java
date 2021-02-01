/*
Question Link: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/?track=md-string&batchId=144
Approach: Simple
*/
class Solution {
    String reverseWords(String S) {
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        int i=len-1;
        int lastDotIndex = len;
        while(i>=0){
            if(S.charAt(i)=='.'){
                sb.append(S.substring(i+1, lastDotIndex)).append('.');
                lastDotIndex=i;
            }
            i--;
        }
        sb.append(S.substring(0, lastDotIndex));
        return sb.toString();
    }
}