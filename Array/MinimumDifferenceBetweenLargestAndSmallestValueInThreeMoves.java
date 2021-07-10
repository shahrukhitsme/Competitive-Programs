/*
Question Link: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/discuss/1328369/JAVA-beats-100
Approach: We dont need to change any values, it is just that we need to remove any 3 numbers, such that max - min is the least. Now if you sort the array, the best ways to remove the numbers are at the ends, becuase then only you would be able to lessen the range. So you can remove the numbers from the end in 4 ways.

3 on left, 0 on right
2 on left, 1 on right
1 on left, 2 on right
0 on left, 3 on right
And by finding which of these yields the minimum range, we get our final answer.
Complexity is O(log n) becasue of sorting.
*/
class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=3) return 0;
        Arrays.sort(nums);
        int lastIndex = nums.length-1;
        return Math.min(Math.min(nums[lastIndex]-nums[3], nums[lastIndex-3]-nums[0]), Math.min(nums[lastIndex-2]-nums[1],nums[lastIndex-1]-nums[2]));
    }
}