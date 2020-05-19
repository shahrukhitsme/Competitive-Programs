/*
Question Link: https://leetcode.com/problems/product-of-array-except-self/
Approach: Left and Right product array.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--)
            ans[i] = nums[i] * ans[i+1];
        for(int i=1; i<nums.length; i++)
            nums[i] = nums[i] * nums[i-1];
        int i;
        ans[0] = ans[1];
        for(i=1; i<nums.length-1; i++)
            ans[i] = ans[i+1] * nums[i-1];
        ans[i] = nums[i-1];
        return ans;
    }
}