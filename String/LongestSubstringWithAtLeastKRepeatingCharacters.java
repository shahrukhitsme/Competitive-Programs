/*
Question Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
Approach: The longest subsequence can have characters ranging from 1 from 26. So, for each number of unique characters, slided a window, to find the longest substring with that many
characters, and did it for all unique counts from 1 to 26, and kept updating the max.
*/
class Solution {
    public int longestSubstring(String s, int k) {
        char[] letters = s.toCharArray();
        int[] freq = new int[26];
        int iter=1;
        int max = 0;
        while(iter<=26){
            int i=0, j=0, unique=0, noLessThanK=0;
            Arrays.fill(freq, 0);
            int locMax = 0;
            while(j<letters.length){
                int charVal;
                if(unique>iter){
                    charVal = letters[i]-'a';
                     if (freq[charVal] == k)
                        noLessThanK--;
                    freq[charVal]--;
                    if (freq[charVal] == 0)
                        unique--;
                    i++;
                }
                else{
                    charVal = letters[j]-'a';
                    if(freq[charVal]==0)
                        unique++;
                    freq[charVal]++;
                    if(freq[charVal]==k)
                        noLessThanK++;
                    j++;
                }
                if(unique == iter && unique==noLessThanK){
                    locMax = Math.max(locMax, j-i);
                }
            }
            iter++;
            max = Math.max(max, locMax);
        }
        return max;
    }
}