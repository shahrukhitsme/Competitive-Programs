/*
Question Link:https://leetcode.com/problems/power-of-three/solution/
Approach1: Check whether 3^19 is divisible by n or not.
Approach2: n = 3^i
i=log(3)n
i=log(10)n/log(10)3
if i is an integer, then n is a power of 3.
*/

//Approach1
class Solution {
    public boolean isPowerOfThree(int n) {
        return (n>0 && 1162261467%n==0);
    }
}
