/*
Question Link: https://leetcode.com/problems/wiggle-sort-ii/
Approach: Find median using priority queue(find kth largest element), and insert all numbers lesser than median at even indices starting from right, and all numbers greater than median
at odd indices starting from left. Fill the remaining places with median.
*/
class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int sizeOfPQ = len/2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currLen = 0;
        for(int num:nums){
            pq.add(num);
            if(currLen>sizeOfPQ)
                pq.poll();
            currLen++;
        }
        int median = pq.poll();
        int[] newNums = new int[len];
        for(int i=0; i<len; i++)
            newNums[i] = nums[i];
        int evenIndex = len%2==0?len-2:len-1;
        int oddIndex = 1;
        for(int num:newNums){
            if(num<median){
                nums[evenIndex] = num;
                evenIndex-=2;
            }
            else if(num>median){
                nums[oddIndex] = num;
                oddIndex+=2;
            }
        }
        for(int i=evenIndex; i>=0; i=i-2)
            nums[i]=median;
        for(int i=oddIndex; i<len; i=i+2)
            nums[i]=median;
    }
}
