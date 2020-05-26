/*
Question Link: https://leetcode.com/problems/find-peak-element/
Approach: Since, both borders are -infinity, there has to be a peak. So we check the mid of the array to check which half is moving towards a higher value, and do the same for that half, and finally when the array is reduced to size of 1, return it.
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int s=0, e=nums.length-1, mid;
        while(s!=e){
            mid = (s+e)/2;
            if(nums[mid]<nums[mid+1]) s=mid+1;
            else e=mid;
        }
        return s;
    }
}