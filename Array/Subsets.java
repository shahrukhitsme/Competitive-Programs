/*
Question Link: https://leetcode.com/problems/subsets/
Approach: Used Recursion. In each iteration, called the function twice, 1.) with the current index character, and 2.) without the current index character.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        doit(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void doit(int[] nums, int index, List<Integer> seq, List<List<Integer>> seqs){
        if(index == nums.length){
            seqs.add(seq);
            return;
        }
        doit(nums, index+1, new ArrayList<>(seq), seqs);
        seq.add(nums[index]);
        doit(nums, index+1, new ArrayList<>(seq), seqs);
    }
}