/*
Question Link: https://leetcode.com/problems/merge-sorted-array/submissions/
Approach: Shifted all numbers of list 1 to the end, and used 2 pointers to compare and put values in the first array.
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = n,p2 = 0, curr = 0;
        if(n==0)
            return;
        for(int i=m+n-1; i>=n; i--)
            nums1[i]=nums1[i-n];
        while(p1<m+n && p2<n){
            if(m!=0 && nums1[p1]<nums2[p2]){
                nums1[curr] = nums1[p1];
                p1++;
            }
            else{
                nums1[curr] = nums2[p2];
                p2++;
            }
            curr++;
        }
        while(p2<n){
            nums1[curr] = nums2[p2];
            p2++;
            curr++;
        }
    }
}