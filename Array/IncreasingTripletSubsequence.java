/*
Question Link: https://leetcode.com/problems/increasing-triplet-subsequence/
Approach: Kept track of 2 increasing numbers, and if the 3rd number greater than previous is found, return true. Whereas, if another set of 2 numbers which is less than the previous set
is found, then replace the first set with this one, and move on.
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int p1=-1, q1=-1, p2=-1, q2=-1;
        for(int i=0; i<nums.length; i++){
			if(q1!=-1 && nums[i]>nums[q1])
				return true;
			if(q1!=-1 && nums[i]>nums[p1] && nums[i]<nums[q1])
				q1 = i;
			if(q1!=-1 && nums[i]<nums[p1] && p2!=-1 && (q2==-1 || nums[q2]>nums[i]))
				q2 = i;
            else if(q1!=-1 && nums[i]<nums[p1] && (p2==-1 || nums[p2]>nums[i]))
				p2 = i;
			if(p1==-1)
				p1 = i;
			else if(q1==-1 && nums[i]<nums[p1])
				p1=i;
			else if(q1==-1 && nums[i]!=nums[p1])
				q1=i;
			if(q1!=-1 && q2!=-1 && nums[q2]<nums[q1]){
				p1 = p2;
				q1 = q2;
				p2 = -1;
				q2 = -1;
			}
        }
		return false;
    }
}