/*
Question Link: https://leetcode.com/problems/longest-consecutive-sequence/
Approach: Used a hashmap, to store all numbers, and marked them unvisited at first. Then for each unvisited number in hashset, kept finding consecutive elements forward and backward, also marking
them visited, and increasing the length. Then compared with maxlength, and updated if required.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> numbers = new HashMap<>();
        for(int num: nums){
            numbers.put(num, false);
        }
        int max = 0;
        int temp = 0;
        for(int key: numbers.keySet()){
            if(numbers.get(key)==true)
                continue;
            temp++;
            numbers.put(key, true);
            int less = key-1;
            while(numbers.containsKey(less)){
                temp++;
                numbers.put(less, true);
                less--;
            }
            int more = key+1;
            while(numbers.containsKey(more)){
                temp++;
                numbers.put(more, true);
                more++;
            }
            if(temp>max)
                max=temp;
            temp=0;
        }
        return max;
    }
}