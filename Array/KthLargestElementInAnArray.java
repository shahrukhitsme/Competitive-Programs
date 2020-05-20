/*
Question Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
Approach: Used Priority Queue
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k==0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++)
            pq.add(nums[i]);
        for(int i=1; i<k; i++)
            pq.poll();
        return pq.poll();
    }
}