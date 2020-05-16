/*
Question Link:https://leetcode.com/problems/number-of-1-bits/
Approach: Right shift the bits and increment count if last bit is 1
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count+=n&1;
            n=n>>>1;;
        }
        return count;
    }
}