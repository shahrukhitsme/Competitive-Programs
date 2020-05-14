/*
Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
Approach: Just add those days' difference when the price of the share increased.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, diff = 0;
        for(int i=0; i<prices.length-1; i++){
            diff = prices[i+1]-prices[i];
            profit += diff>0?diff:0;
        }
        return profit;
    }
}