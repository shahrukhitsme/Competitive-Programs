/*
Question Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Approach: Used binary search to find the occurences, and update the minimum and maximum index of occurrence.
*/
class Solution {
    int min = Integer.MAX_VALUE, max = -1;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length>0)
            findTarget(nums, target, 0, nums.length-1);
        int[] res = new int[2];
        res[0] = min>nums.length?-1:min;
        res[1]=max;
        return res;
    }
    
    public void findTarget(int[] nums, int target, int s, int e) {
        if(s>e)
            return;
        int mid = (s+e)/2;
        if(nums[mid]>target)
            findTarget(nums, target, s, mid-1);
        else if(nums[mid]<target)
            findTarget(nums, target, mid+1, e);
        else{
            if(mid<min)
                min = mid;
            if(mid>max)
                max = mid;
            findTarget(nums, target, s, mid-1);
            findTarget(nums, target, mid+1, e);
        }
    }
}