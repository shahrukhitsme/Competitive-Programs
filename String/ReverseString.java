/*
Question Link: https://leetcode.com/problems/reverse-string/
Approach: Swapping indexes from left and right at same distance.
*/
class Solution {
    public void reverseString(char[] str) {
        int s = 0, e = str.length-1;
        char temp;
        while(s<e){
            temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }
}