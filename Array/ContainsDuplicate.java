/*
Question Link: https://leetcode.com/problems/contains-duplicate/
Approach: Used a HashSet to track whether an element has already been entered or not.
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> n = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(n.contains(nums[i]))
                return true;
            n.add(nums[i]);
        }
        return false;
    }
}