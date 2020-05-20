/*
Question Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
Approach: Keep traversing from left till value is increasing, and from right till value is decreasing. Then find min and max in that window, and again go beyond left and right to check
if window needs to be expanded.
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int end = nums.length - 1, start = 0;
        int rep=0;
        while(end>0){
            if(nums[end]==nums[end-1]){
                end--;
                rep++;
            }
            else if(nums[end]>nums[end-1]){
                end--;
                rep=0;
            }
            else{
                end = end+rep;
                break;
            }
        }
        rep = 0;
        while(start<nums.length-1){
            if(nums[start]==nums[start+1]){
                start++;
                rep++;
            }
            else if(nums[start]<nums[start+1]){
                start++;
                rep = 0;
            }
            else{
                start = start-rep;
                break;
            }
        }
        if(end<=start)
            return 0;
        int max = nums[start], min = nums[start];
        for(int i=start; i<=end; i++){
            if(max<nums[i])
                max = nums[i];
            if(min>nums[i])
                min = nums[i];
        }
        while(end<nums.length-1){
            if(max>nums[end+1])
                end++;
            else
                break;
        }
        while(start>=1){
            if(min<nums[start-1])
                start--;
            else
                break;
        }
        return end-start+1;
    }
}