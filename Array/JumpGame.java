/*
Question Link: https://leetcode.com/problems/jump-game/
Approach: Starting from first index, get the jump, and then get the next biggest jump from amongst the possible indexes from where we could jump, and so on.
*/
class Solution {
    public boolean canJump(int[] nums) {
        int st=0, en=0;
        while(en<nums.length-1){
            int max = 0;
            for(int i=st; i<=en; i++){
                if((i+nums[i])>max)
                    max=nums[i]+i;
            }
            if(max<=en && en<nums.length-1)
                return false;
            st=en+1;
            en=max;
        }
        return true;
    }
}