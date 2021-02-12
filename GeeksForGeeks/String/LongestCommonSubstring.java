/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/0/?track=md-string&batchId=144#
Approach: For each character in first string find the same character positions in second and check for common substrings from there. Keep updating max.
*/
class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int max = 0;
        for(int i=0; i<n; i++){
            int temp = getMax(S1, S2, i, n, m);
            if(temp > max)
                max = temp;
        }
        return max;
    }
    
    int getMax(String S1, String S2, int i, int n, int m){
        int max = 0;
        for(int j=0; j<m; j++){
            int temp = getCommon(S1, S2, i, j, n, m);
            if(temp > max)
                max = temp;
        }
        return max;
    }
    
    int getCommon(String S1, String S2, int i, int j, int n, int m){
        int count = 0;
        while(i<n && j<m){
            if(S1.charAt(i)==S2.charAt(j))
                count++;
            else
                return count;
            i++;
            j++;
        }
        return count;
    }
}