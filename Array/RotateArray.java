/*
Question Link: https://leetcode.com/problems/rotate-array/
Approach1: let GCD of k, and length of array be g. The array must be traversed at an interval of k, in g different groups.
Approach2: reverse the whole array, reverse 0 to k-1, and reverse k to length
*/

//Approach1
class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if(k==0 || l==0 || l==1)
            return;
        int groups = gcd(l, k);
        int j, temp1, temp2;
        for(int i=0; i<groups; i++){
            j=(i+k)%l;
            temp1 = nums[i];
            while(j!=i){
                temp2 = nums[j];
                nums[j] = temp1;
                temp1 = temp2;
                j = (j+k)%l;
            }
            nums[i] = temp1;
        }
    }
    
    public int gcd(int num1, int num2){
        while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }
}