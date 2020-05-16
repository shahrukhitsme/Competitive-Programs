/*
Question Link: https://leetcode.com/problems/sum-of-two-integers/submissions/
Approach: XOR both, and then AND, left shift to find the carry, and XOR the carry with the previous XOR. Then again AND and check if there is still carry. Keep repeating it.
*/
class Solution {
    public int getSum(int a, int b) {
        //return b==0? a:getSum(a^b, (a&b)<<1);
        int c = a ^ b;
        b = a & b;
        b = b << 1;
        a = c;
        while(b!=0){
            c = a ^ b;
            b = a & b;
            b = b << 1;
            a = c;
        }
        return c;
    }
}