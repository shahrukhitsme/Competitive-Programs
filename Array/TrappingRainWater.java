/*
Question Link: https://leetcode.com/problems/trapping-rain-water
Approach: Used 2 pointers from start. Kept 1 pointer fixed, and moved the other to find the next height which is greater or equal to the current height. If found, added the water trapped,
and set the first pointer to the pointer having the next height. If no height is found which is greater or equal, find the max height after the current height. And calculate water 
trapped accordingly, then set the first pointer to the index having that height.
*/
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int i, j;
        for(j=0; j<height.length; j++){
            if(height[j]>0){
                break;
            }  
        }
        i=j;
        while(i<height.length){
            for(j=i+1; j<height.length; j++){
                if(height[j]>=height[i]){
                    break;
                }
            }
            if(j<height.length){
                for(int k=i+1; k<j; k++){
                    res+=(height[i]-height[k]);
                }
                i=j;
            }
            else{
                int maxH = 0, maxH_index=i+1;
                for(j=i+1; j<height.length; j++){
                    if(height[j]>maxH){
                        maxH = height[j];
                        maxH_index = j;
                    }
                }
                for(int k=i+1; k<maxH_index; k++){
                    res+=(maxH-height[k]);
                }
                i=maxH_index;
            }
        }
        return res;
    }
}