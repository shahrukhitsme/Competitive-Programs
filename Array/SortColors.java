/*
Question Link: https://leetcode.com/problems/sort-colors/
Approach: Travers from left and right, and keep updating 0's to the left, and 2's to the right. Finally, update the remaining with 1's
*/
class Solution {
    public void sortColors(int[] nums) {
        int start = 0, afterZero=0, end=nums.length-1, beforeTwo=nums.length-1;
        while(start<=end){
            while(start<=end && start<nums.length && nums[start]==0){
                start++;
                nums[afterZero]=0;
                afterZero++;
            }
            while(start<=end && end>=0 && nums[end]==2){
                end--;
                nums[beforeTwo]=2;
                beforeTwo--;
            }
            if(start<=end && nums[start]==2){
                if(nums[end]==0){
                    nums[afterZero]=0;
                    afterZero++;
                }
                nums[beforeTwo]=2;
                beforeTwo--;
                start++;
                end--;
            }
            else
                start++;
        }
        for(int i=afterZero; i<=beforeTwo; i++)
            nums[i]=1;
    }
}