/*
Question Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
Approach: Used prefixSum array and suffix sum array to find the combination in O(k) time. Problem could also be viewed as to find the subarray with minimum points and we could use sliding window then.
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] prefixSum = new int[len];
        int[] suffixSum = new int[len];
        prefixSum[0] = cardPoints[0];
        suffixSum[len-1] = cardPoints[len-1];
        for(int i=1; i<len; i++){
            prefixSum[i] = cardPoints[i] + prefixSum[i-1];
            suffixSum[len-1-i] = cardPoints[len-1-i] + suffixSum[len-i]; 
        }
        
        int max=0;
        for(int i=0; i<=k; i++){
            int leftGrp = i;
            int rightGrp = k-i;
            int leftSum=0, rightSum=0;
            if(leftGrp!=0) leftSum=prefixSum[leftGrp-1];
            if(rightGrp!=0) rightSum=suffixSum[len-rightGrp];
            int currSum = leftSum+rightSum;
            if(currSum>max)
                max=currSum;
        }
        
        return max;
    }
}