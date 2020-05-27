/*
Question Link: https://leetcode.com/problems/longest-increasing-subsequence/
Approach: Used patience sort, or tails array.
tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        tails[0] = nums[0];
        for(int x: nums){
            int i=0, j=size, m;
            while(i<=j){
                m = (i+j)/2;
                if(x==tails[m]){
                    i=m;
                    break;
                }
                if(x<tails[m])
                    j=m-1;
                else
                    i=m+1;
            }
            if(i>size)
                size = i;
            tails[i]=x;
        }
        return size+1;
    }
}