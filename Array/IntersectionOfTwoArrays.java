/*
Question Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
Approach: Used a hashmap to store frequency of each number in first array. Then traversed array, and found if it existed in first array, and decremented the frequency.
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(nums.containsKey(nums1[i]))
                nums.put(nums1[i], nums.get(nums1[i])+1);
            else
                nums.put(nums1[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(nums.containsKey(nums2[i]) && nums.get(nums2[i]) > 0){
                list.add(nums2[i]);
                nums.put(nums2[i], nums.get(nums2[i])-1);
            }
        }
        
        int[] arr = new int[list.size()]; 
  
        // ArrayList to Array Conversion 
        for (int i =0; i < list.size(); i++) 
            arr[i] = list.get(i); 
        return arr;
    }
}