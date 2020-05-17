/*
Question Link: https://leetcode.com/problems/sqrtx/
Approach: Used binary search to find the correct number
*/
class Solution {
    public int mySqrt(int x) {
        if(x==1)
            return 1;
        int l=0, r=x/2;
        return findRoot(l, r+1, x);
    }
    
    public int findRoot(int a, int b, int x){
        if(a==b)
            return a;
        int n = (a+b)/2;
        double sq1 = Math.pow(n+1,2), sq2 = Math.pow(n,2);
        if(sq1>x && sq2<=x)
            return n;
        else if(sq1<=x)
            return findRoot(n, b, x);
        else
            return findRoot(a, n, x);
    }
}