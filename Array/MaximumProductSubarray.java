/*
Question Link: https://leetcode.com/problems/maximum-product-subarray/
Approach: Kept multiplying, and also updating max. When product is negative, checked by removing the product till first negative number after last zero.
*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int start=-1, end = 1, max = nums[0], product=nums[0], negProduct=nums[0]==0?1:nums[0], lastZero=-2;
        if(nums[0]<0)
            start=0;
        while(end<nums.length){
            if(product==0)
                product=nums[end];
            else
                product*=nums[end];
            if(product>max)
                max=product;
            if(start==-1){
                if(nums[end]==0)
                    negProduct=1;
                else{
                    if(negProduct==0)
                        negProduct=nums[end];
                    else
                        negProduct*=nums[end];
                    if(nums[end]<0)
                        start=end;
                }
            }
            if(nums[end]==0){
                lastZero=end;
                start=-1;
                product=0;
                negProduct=0;
            }
            if(product<0 && start!=-1 && product/negProduct>max && start!=end)
            {
                max=product/negProduct;
            }
            end++;
        }
        return max;
    }
}