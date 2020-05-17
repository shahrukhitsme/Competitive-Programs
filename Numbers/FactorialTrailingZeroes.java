/*
Question Link: https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
Approach: Find the number of 5's in its factorization, by keeping on dividing it by 5.
*/
class Solution {
    public int trailingZeroes(int n) {
        int fives = 0;
        while(n>=5){
            fives+=n/5;
            n/=5;
        }
        return fives;
    }
}