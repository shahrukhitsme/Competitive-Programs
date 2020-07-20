/*
Question Link: https://leetcode.com/problems/sliding-window-maximum/
Approach: Linear traversal keeping 2 pointers, which keep track of the window length not exceeding the limit, as well as the maximum value in the current window. Always, i<=j and j-i+1<k. When you increase
 j, check if window size has exceeded the limit. If yes, update the pointer 'i', with the index having max value in that window, else, just check if j has a value which is greater than current max.
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int i=0, j=0;
        for(; j<k; j++){
            if(nums[j]>nums[i]) i=j;
        }
        res[0]=nums[i];
        for(; j<nums.length; j++){
            if(j-i>=k){
                i++;
                for(int iter=i+1;iter<=j; iter++){
                    if(nums[iter]>nums[i])  i=iter;
                }
            }
            else if(nums[j]>nums[i])
                i=j;
            res[j-k+1]=nums[i];
        }
        return res;
    }
}