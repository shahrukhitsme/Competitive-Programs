/*
Question Link: https://practice.geeksforgeeks.org/problems/coin-change2448/1#
Approach: Use Dynamic programming. Create a 2D array of rows denoting the number of coins, and columns denoting the amount. For any index, the value in that cell is equal to the number of ways that amount can be reached using or not using that many coins. So, that is equal to the sum of value denoting the amount-that coin value and same row, and the value denoting same amount, but 1 less number of coins. So, dp[i][j] = dp[i][amount - coin[i]] + dp[i-1][amount], where amount at that cell is equal to the column number, j.
*/
class Solution
{
    HashMap<Integer, HashMap<Integer, Integer>> mp;
    public long count(int S[], int m, int n) 
    { 
        long[][] dp = new long[m+1][n+1];
        for(int i=0; i<=m; i++)
            dp[i][0] = 1;
        for(int i=1; i<=n; i++)
            dp[0][i] = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = (S[i-1]<=j?(dp[i][j-S[i-1]]):0) + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}