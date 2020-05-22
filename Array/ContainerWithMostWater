/*
Question Link: https://leetcode.com/problems/container-with-most-water/
Approach: 2 pointers from left and right, keep updating the pointer with shorted height, and the maximum capacity.
*/
class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = 0;
        int i=0,j= height.size()-1;
        int area, sHeight;
        while(i<j)
        {
            if(height[i] < height[j])
                sHeight = height[i];
            else
                sHeight = height[j];
            area = (j-i)*sHeight;
            if(area>max)
                max=area;
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
};