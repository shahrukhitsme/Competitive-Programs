/*
Question Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
Approach: First found the pivot, then did binary search on the left subarray and right subarray.
*/
class Solution {
    public int search(int[] nums, int target) {
        int pivot;
        if(nums.length==0)
            return -1;
        pivot = findPivot(nums, 0, nums.length-1);
        int index = binarySearch(nums, 0, pivot-1, target);
        if(index==-1)
            index = binarySearch(nums, pivot, nums.length-1, target);
        return index;
    }
    
    public int findPivot(int[] nums, int l, int r){
        if(nums[l]<nums[r])
            return l;
        if(l>r)
            return 0;
        int m = (l+r)/2;
        if(m==0 && m==nums.length-1)
            return m;
        if(m==0 && nums[m]>nums[m+1])
            return m+1;
        if(m==nums.length-1 && nums[m]>nums[m-1])
            return m-1;
        if(m==0 || m==nums.length-1)
            return m;
        if(nums[m]<=nums[m-1] && nums[m]<=nums[m+1])
            return m;
        else if(nums[m]>=nums[l])
            return findPivot(nums, m+1, r);
        else
            return findPivot(nums, l, m-1);
    }
    
    public int binarySearch(int[] nums, int l, int r, int target){
        if(l>r)
            return -1;
        int m = (l+r)/2;
        if(nums[m]==target)
            return m;
        if(nums[m]<target)
            return binarySearch(nums, m+1, r, target);
        return binarySearch(nums, l, m-1, target);
    }
}