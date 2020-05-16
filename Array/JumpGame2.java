/*
Question Link:https://leetcode.com/problems/jump-game-ii/
Approach: For the first index, find the maximum index it can go to. From index 1 till that max index will be at level 2. Then do the same to find level 3, and so on.
The number of levels - 1, is the minimum number of jumps required.
Approach 2: Using DP, but it got TLE in one case of a large sorted array.
*/
//Approach 1:
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int l=0, r=0, maxIndex = 0;
        while(r<nums.length-1){
            maxIndex = r;
            for(int i=l; i<=r; i++)
            {
                if(nums[i]+i>maxIndex)
                    maxIndex=nums[i]+i;
            }
            l=r+1;
            r=maxIndex;
            count++;
        }
        return count;
    }
}

//Approach 2:
/*
class Solution {
    int[] steps;
    public int jump(int[] nums) {
        steps = new int[nums.length];
        int res = getSteps(nums, 0);
        return res;
    }
    
    public int getSteps(int[] nums, int index){
        System.out.print(index+" , ");
        if(index==nums.length-1)
            return 0;
        if(index >= nums.length)
            return 1;
        if(steps[index]!=0)
            return steps[index];
        int min = nums.length, temp;
        for(int i=nums[index]; i>=1 ; i--){
            temp = getSteps(nums, index+i);
            steps[index] = temp;
            if(temp < min)
                min = temp;
        }
        steps[index] = min+1;
        return min+1;
    }
}
*/