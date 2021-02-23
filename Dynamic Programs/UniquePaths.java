/*
Question Link: https://leetcode.com/problems/unique-paths/submissions/
Approach: Number of ways to reach a cell is equal to the sum of number of ways to reach above cell and number of ways to reach left cell.
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1; i<m; i++)
            dp[i][0] = 1;
        for(int j=1; j<n; j++)
            dp[0][j] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
}