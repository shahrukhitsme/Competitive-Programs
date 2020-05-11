/*
Question link: https://leetcode.com/problems/move-zeroes/submissions/
Approach: To simply traverse the array and keep track of the number of occurences of non zero elements fond and update them at correct position in array. And then run a loop to set zero to remaining elements.
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        for(int i=nonZeroIndex; i<nums.length; i++)
            nums[i] = 0;
    }
}