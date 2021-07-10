/*
Question Link: https://leetcode.com/problems/koko-eating-bananas/
Approach: O(nlogn), The maximum K which would be sufficient would be the max pile length, and minimum k would be 0, which would be insufficient. Do a binary search in that range to find the minimum possible k which would be sufficient.
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = piles[0];
        for(int i=0; i<piles.length; i++){
            if(piles[i]>hi)
                hi = piles[i];
        }
        int lo = 1;
        while(lo<hi){
            int m = (lo+hi) >> 1;
            if(isPossible(piles, m, h))
                hi=m;
            else
                lo=m+1;
        }
        return lo;
    }
    
    public boolean isPossible(int[] piles, int k, int h){
        int timeTaken = 0;
        for(int i=0; i<piles.length; i++)
            timeTaken += (piles[i]-1)/k + 1;
        return timeTaken <= h;
    }
}