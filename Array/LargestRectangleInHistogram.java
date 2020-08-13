/*
Question Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
Approach: For each bar, we need to find the maximum rectangle around it, which is of the same height as itself. So, we first store the index of the first bar to the left and to the right
which is smaller than the current bar in 2 arrays. Then we traverse all the bars, and find the maximum area.
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] lesserFromLeft = new int[heights.length];
        int[] lesserFromRight = new int[heights.length];
        processLesser(lesserFromLeft, heights, 0, heights.length, 1);
        processLesser(lesserFromRight, heights, heights.length-1, -1, -1);
        int maxArea = 0;
        for(int i=0; i<heights.length; i++)
            maxArea = Math.max(maxArea, heights[i]*(lesserFromRight[i]-lesserFromLeft[i]+1));
        return maxArea;
    }
    
    public void processLesser(int[] array, int[] heights, int start, int end, int step){
        for(int i=start; i!=end; i=i+step){
            array[i] = i;
            int j = i;
            while(j!=start-step && heights[j]>=heights[i]){
                array[i] = array[j];
                j-=step;
            }
        }
    }
}