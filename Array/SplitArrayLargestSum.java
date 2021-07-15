/*
Question Link: https://leetcode.com/problems/split-array-largest-sum/
Approach: In this type of question in which we need to find something like, find minimum of maximum or find maximum of minimum, then most of the times it is done using a binary search. The max possible partition is sum of all numbers and the min possible is the maximum number in the array, so we would do a binary search in that range to find the minimum such sum for which m partitions are possible.
*/
class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int maxNum = nums[0];
        int sum = nums[0];
        for(int i=1; i<len; i++){
            if(nums[i]>maxNum)
                maxNum = nums[i];
            sum+=nums[i];
        }
        if(m==len)
            return maxNum;
        if(m==1)
            return sum;
        int l=maxNum;
        int r=sum;
        int res=sum;
        while(l<r){
            int mid=(l+r)/2;
            if(isPossible(nums, mid, m)){
                res=mid;
                r=mid;
            } else
                l=mid+1;
        }
        
        return res;
    }
    
    public boolean isPossible(int[] nums, int sum, int allowedPartitions){
        int i=0;
        int partitions = 0;
        int tempSum = 0;
        while(i<nums.length){
            while(tempSum<=sum){
                if(i>=nums.length)
                    break;
                tempSum += nums[i];
                if(tempSum>sum)
                    break;
                i++;
            }
            partitions++;
            tempSum = 0;
        }
        if(partitions>allowedPartitions)
            return false;
        return true;
    }
}