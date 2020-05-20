/*
Question Link: https://leetcode.com/problems/find-the-duplicate-number/
Approach: For each element of array, use the value as index, and negate the value at that index. If at any point, the value is already negative, then that is the answer.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            int val = Math.abs(nums[i]);
            if(nums[val]<0)
                return val;
            nums[val] = -nums[val];
        }
        return 1;
    }
}