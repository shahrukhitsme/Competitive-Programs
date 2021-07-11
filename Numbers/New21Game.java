/*
Question Link: https://leetcode.com/problems/new-21-game/
Approach: Given the maxPoints = w, Probability to reach an index = (sum of (previous w indices=>(probability to reach that index/w))) = (sum of probabilities to reach previous previous w indices)/w.
Thus traverse the array and keep maintaining the window sum and update the probability array. Answer is the sum of probabilities in the window (k,n].
*/
class Solution {
    public double new21Game(int n, int k, int w) {
        if(k==0 || n>=k+w) return 1.0;
        double[] dp = new double[n+1];
        double wsum=1.0;
        double res = 0;
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            dp[i] = wsum/w;
            if(i<k) wsum+=dp[i]; else res+=dp[i];
            if(i-w>=0) wsum-=dp[i-w];
        }
        return res;
    }
}