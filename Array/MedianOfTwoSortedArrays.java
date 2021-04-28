/*
Question Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
Approach: Found the index at which the median should be by adding the length of both the arrays. Then used 2 pointers, one for each array to traverse the arrays and find that median.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1+l2;
        int median;
        if(l%2==0){
            median=l/2;
        }
        else median=(l+1)/2;
        median--;
        int p1=0, p2=0;
        while(p1<l1 || p2<l2){
            if(median==0){
                if(p1==l1){
                    if(l%2==0)
                        return (double)(nums2[p2]+nums2[p2+1])/2;
                    return (double)nums2[p2];
                }
                if(p2==l2){
                    if(l%2==0)
                        return (double)(nums1[p1]+nums1[p1+1])/2;
                    return (double)nums1[p1];
                }
                if(l%2==0){
                    int a,b;
                    if(nums1[p1]<nums2[p2]){
                        a=nums1[p1];
                        p1++;
                    }
                    else{
                        a=nums2[p2];
                        p2++;
                    }
                    if(p1==l1)
                        b=nums2[p2];
                    else if(p2==l2)
                        b=nums1[p1];
                    else if(nums1[p1]<nums2[p2])
                        b=nums1[p1];
                    else
                        b=nums2[p2];
                    return (double)(a+b)/2;
                }
                if(nums1[p1]<nums2[p2])
                    return nums1[p1];
                return nums2[p2];
            }
            if(p1!=l1 && p2!=l2){
                if(nums1[p1]<nums2[p2])
                    p1++;
                else p2++;
                median--;
            }
            else if(p1==l1){
                p2+=median;
                median=0;
            }
            else if(p2==l2){
                p1+=median;
                median=0;
            }
            else return (double)(-1);
        }
        return -1;
    }
}