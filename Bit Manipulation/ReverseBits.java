/*
Question Link: https://leetcode.com/problems/reverse-bits/
Approach: Initialize a variable, add last bit of input to variable, and left shift it.And right shift the input. Keep doing it 32 times.
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=1; i<=32; i++){
            res = res << 1;
            res = res | (n&1);
            n = n >> 1;
        }
        return res;
    }
}