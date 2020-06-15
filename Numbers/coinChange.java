/*
Question Link: https://leetcode.com/problems/coin-change/
Approach: DP
*/
class Solution {
	int[] coinCount;
    public int coinChange(int[] coins, int amount) {
        coinCount = new int[amount+1];
		return count(coins, amount);
    }
	
	public int count(int[] coins, int amount){
		if(coinCount[amount]!=0 || amount==0)
			return coinCount[amount];
		int min = Integer.MAX_VALUE;
		for(int coin: coins){
			if(amount-coin>=0){
				int temp = count(coins, amount-coin);
				if(temp!=-1 && temp<min)
					min = temp+1;
			}
		}
		if(min==Integer.MAX_VALUE)
			coinCount[amount]=-1;
		else
			coinCount[amount]=min;
		return coinCount[amount];
	}
}