/*
Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
Approach: Modified the array to store differences between consecutive elements. Ex: 7 1 5 3 6 4 will become -6 4 -2 4 -2
Then used sliding window technique to find the window with maximum sum. Whenever the window sum<0, window is reset and both start and end point to the index next to the window end. 
Because it's useless to carry negative forward, as it will anyways decrease the window sum going forward.
Otherwide only end is moved forward by one.
And after each movement of window, the maximum is compared and updated if required.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        for(int i=1; i<prices.length; i++)
            prices[i-1] = prices[i] - prices[i-1]; //difference between each consecutive element till length = prices.length-1
        int s = 0, e = 0, profit = prices[0];
        int maxProfit = profit>0?profit:0;
        while(s<prices.length-2 && e<prices.length-2){
            if(profit < 0){
                e++;
                s=e;
                profit = prices[s];
            }
            else{
                e++;
                profit+=prices[e];
            }
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}