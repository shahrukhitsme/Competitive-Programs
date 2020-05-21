/*
Question Link: https://leetcode.com/problems/shuffle-an-array/
Approach: Copied all elements to an arraylist, and generated random number from 0 to i, where i decreases from length of array to 1. And the element at index = random number is added to the result array. Repeat the process till all elements have been added.
*/
class Solution {
    List<Integer> numbers;
    int[] original;
    public Solution(int[] nums) {
        numbers = new ArrayList<>();
        original = nums;
        for(int i=0; i<nums.length; i++)
            numbers.add(nums[i]);  
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[original.length];
        List<Integer> numSet = new ArrayList<>(numbers);
        Random rand = new Random(); 
        int random;
        int i=original.length;
        while(i>0){
            random = rand.nextInt(i);
            res[i-1] = numSet.get(random);
            numSet.remove(random);
            i--;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */