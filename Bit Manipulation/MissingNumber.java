/*
Question Link: https://leetcode.com/problems/missing-number/submissions/
Approach: Traverse and keep doing xor with the previous xor and current index;
*/
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}