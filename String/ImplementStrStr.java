/*
Question Link: https://leetcode.com/problems/implement-strstr/
Approach: BruteForce
*/
class Solution {
    public int strStr(String haystack, String needle) {
        StringBuilder str = new StringBuilder();
        str.append(haystack);
        if(needle=="")
            return 0;
        else if(haystack=="")
            return -1;
        int l = needle.length();
        for(int i=0; i<=haystack.length()-l; i++){
            if(needle.equals(str.substring(i, i+l)))
                return i;
        }
        return -1;
    }
}