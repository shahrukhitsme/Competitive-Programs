/*
Question Link: https://leetcode.com/problems/valid-anagram/
Approach: Use an array of length 26, and traverse the strings and update the index corresponding to the character in the strings. Increment the count for first string and decrement for second.
If all the indices of the array are 0, return true, else return false.
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] alpha = new int[26];
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i)-97]++;
            alpha[t.charAt(i)-97]--;
        }
        for(int i=0; i<26; i++)
        {
            if(alpha[i]!=0)
                return false;
        }
        return true;
    }
}