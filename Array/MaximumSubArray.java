/*
Question Link: https://leetcode.com/problems/maximum-subarray/submissions/
Approach: Sliding Window Approach
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return Integer.MIN_VALUE;
        int sum = 0, i=0, j=0, max=nums[0];
        while(i<=j && j<nums.length){
            sum+=nums[j];
            j++;
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
            i=j;
        }
        return max;
    }
}