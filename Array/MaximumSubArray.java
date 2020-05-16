/*
Question Link: https://leetcode.com/problems/maximum-subarray/submissions/
Approach: Sliding Window Approach
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return Integer.MIN_VALUE;
        int l=0, r=0;
        int s = nums[0];
        int max = s;
        while(r<nums.length-1){
            if(s<=0){
                r = r+1;
                l = r;
                s = nums[l];
            }
            else{
                r++;
                s+=nums[r];
            }
            if(s>max)
                max = s;
        }
        return max;
    }
}