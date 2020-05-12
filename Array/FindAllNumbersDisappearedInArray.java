/*
Question link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Approach 1: Mark the indexes as -1, which are encountered. Traverse again, and the ones which are positive are the ones missing.
Approach 2: Traversed linearly, and swapped the value of current index with the value at that particular index, at which this value would have been present. If current index is still not correct,
 then again did the same, and kept doing until it is correct. If the value to be swapped is same, then current index value is set to -2 and moved on. If current index value is correct, move on.
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		int temp;
        for(int i=0; i<nums.length; i++){
            temp = Math.abs(nums[i])-1;
            if(nums[temp]>0)
			    nums[temp] = -nums[temp];
        }
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			if(nums[i] > 0)
				res.add(i+1);
		}
		return res;
    }
}

/*Approach 2:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		int temp;
        for(int i=0; i<nums.length; i++){
			if(nums[i] != i+1 && nums[i]!=-2){
				if(nums[i]!=nums[nums[i]-1]){
					temp = nums[nums[i]-1];
					nums[nums[i]-1] = nums[i];
					nums[i] = temp;
				}
				else
					nums[i] = -2;
			}
			if(nums[i] != i+1 && nums[i] != -2)
				i--;
		}
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			if(nums[i] == -2)
				res.add(i+1);
		}
		return res;
    }
}
*/