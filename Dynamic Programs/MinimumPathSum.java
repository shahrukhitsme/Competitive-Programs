/*
Question Link: https://leetcode.com/problems/minimum-path-sum/submissions/
Approach: For any cell, the path can either come from left or above, so the minimum cost to reach that cell is equal to the cost of that cell + the minimum of costs of reaching left and top cells.
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows==0)
            return 0;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for(int i=1; i<rows; i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j=1; j<cols; j++)
            dp[0][j] = grid[0][j] + dp[0][j-1];
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[rows-1][cols-1];
    }
}