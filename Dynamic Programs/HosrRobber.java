/*
Question Link: https://leetcode.com/problems/house-robber/submissions/
Approach: DP. For each index, consider taking it with the solution of subarray which is 1 index away from it, and not taking it with the subarray just after that index,
 and call the function recursively to reach till end. End cases are when last index is asked for, and when last 2 indeces are asked for.
*/
class Solution {
    int[] maxArr;
    public int rob(int[] nums) {
        maxArr = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            maxArr[i] = -1;
        return getMax(nums, 0);
    }
    
    public int getMax(int[] nums, int index){
        if(index>=nums.length)
            return 0;
        if(maxArr[index]!=-1)
            return maxArr[index];
        if(index==nums.length-1)
            return nums[nums.length-1];
        else if(index==nums.length-2)
            return Math.max(nums[nums.length-1],nums[nums.length-2]);
        maxArr[index] = Math.max(getMax(nums, index+1), getMax(nums, index+2)+nums[index]);
        return maxArr[index];
    }
}