/*
Question Link: https://leetcode.com/problems/stone-game-iii/
Approach: Its is a recursive solution. We implement a function which would take in the index of the array, and return the maximum difference a person starting at that index can get. We do so by comparing the result from 3 possibilities which are choosing 1,2 or 3 stones. If we choose suppose 2 stones, then the difference would be current stone value + next stone value - (recursive function with i+2). We can store the results in a dp array because there are overlapping subproblems.
*/
class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        int res = getScore(stoneValue, 0, len);
        if(res>0) return "Alice";
        if(res<0) return "Bob";
        return "Tie";
    }
    
    public int getScore(int[] stoneValue, int i, int len){
        if(i>=len)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        if(i==len-1)
            return stoneValue[len-1];
        if(i==len-2)
            return Math.max(stoneValue[len-2]-stoneValue[len-1], stoneValue[len-2]+stoneValue[len-1]);
        int one = stoneValue[i] - getScore(stoneValue, i+1, len);
        int two = stoneValue[i] + stoneValue[i+1] - getScore(stoneValue, i+2, len);
        int three = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - getScore(stoneValue, i+3, len);
        int res = Math.max(one, Math.max(two, three));
        dp[i] = res;
        return res;
    }
}