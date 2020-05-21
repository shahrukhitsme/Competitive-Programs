/*
Question Link: https://leetcode.com/problems/unique-paths/
Approach: DP
*/
class Solution {
    int[][] dp;
    int l,h;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        l=m-1;
        h=n-1;
        int res = getNumberOfPaths(0,0);
        return res;
    }
    
    public int getNumberOfPaths(int m, int n){
        if(m>l||n>h)
            return 0;
        if(m==l || n==h) return 1;
        if(dp[m][n]>0) return dp[m][n];
        else dp[m][n] = getNumberOfPaths(m+1,n) + getNumberOfPaths(m,n+1);
        return dp[m][n];
    }
}