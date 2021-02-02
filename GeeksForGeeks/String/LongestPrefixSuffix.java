/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/0/?track=md-string&batchId=144
Approve: O(n) traversal of string
*/
class Solution {
    int lps(String s) {
        int len = s.length();
        int i;
        int max=0;
        for(i=1; i<len; i++){
            if(s.substring(0, i).equals(s.substring(len-i, len)))
                max=i;
        }
        return max;
    }
}