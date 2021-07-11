/*
Question Link: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
Approach: Whenever the current element n is bigger than the previous element, we need at lease n - pre operations to make this difference.
*/
class Solution {
    public int minNumberOperations(int[] target) {
        int lastHeight = 0;
        int res = 0;
        for(int i=0; i<target.length; i++){
            int currHeight = target[i];
            if(currHeight>lastHeight){
                res+=(currHeight-lastHeight);
            }
            lastHeight = currHeight;
        }
        return res;
    }
}