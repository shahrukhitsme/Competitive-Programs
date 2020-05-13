/*
Question Link: https://leetcode.com/problems/climbing-stairs/submissions/
Approach: Dynamic Programming. Recursive method which returns the number of ways you can climb n stairs, by calling itself again for n-1 and n-2 and adding them. Also it stores the result in an array
before returning. So, at the start of recursive call, it also checks whether value alrady exists or not.
*/
class Solution {
    int[] steps;
    public int climbStairs(int n) {
        steps = new int[n+1];
        for(int i=0; i<=n; i++)
            steps[i]=-1;
        return traverse(n);
    }
    public int traverse(int n){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(steps[n]!=-1)
            return steps[n];
        if(n>0){
            steps[n] =  traverse(n-1) + traverse(n-2);
        }
        return steps[n];
    }
}