/*
Question Link: https://leetcode.com/problems/permutations/submissions/
Approach: Used Recursion. Pass already built permutation to function. If length is complete, add it to whole list. Else add the new number to each position of the permutation and again pass it to the function.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length == 0)
            return results;
        doit(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    public void doit(int[] nums, int index, List<Integer> permutation, List<List<Integer>> permutations){
        if(permutation.size() == nums.length)
        {
            permutations.add(permutation);
            return;
        }
        
        for(int i=0; i<=permutation.size(); i++){
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[index]);
            doit(nums, index+1, newPermutation, permutations);
        }
    }
}