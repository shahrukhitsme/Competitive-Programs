/*
Question Link: https://leetcode.com/problems/3sum/
Approach: Sorted the array. Traversed the array. In each iteration, found the other two numbers, by converging the second number from that index+1, and from the end. And if sum is 0,
 added it to the result. Whenever there are duplicate numbers skipped them. If sum is equal to zero, then i2++ and i3--., else if it is less that 0, then incremeneted the second index,
 and if it is greater than 0, then decremented the third index.
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int i2 = i+1, i3 = nums.length-1;
            while(i2<i3){
                if(nums[i]+nums[i2]+nums[i3]==0){
                    res.add(Arrays.asList(nums[i],nums[i2],nums[i3]));
                    i2++;
                    i3--;
                    while(i2<i3 && nums[i2]==nums[i2-1])
                        i2++;
                    while(i2<i3 && nums[i3]==nums[i3+1])
                        i3--;
                }
                else if(nums[i]+nums[i2]+nums[i3]<0)
                    i2++;
                else
                    i3--;
            }
        }
        return res;
    }
}