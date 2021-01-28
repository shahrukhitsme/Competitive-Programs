/*
Question Link: https://practice.geeksforgeeks.org/problems/number-of-paths0926/1/?track=md-recursion&batchId=144#
Approach: Just simple recursion
*/
class Solution{
    
    long numberOfPaths(int m, int n) {
        return getPathCount(0, 0, m, n, 0)/2;
    }
    
    long getPathCount(int i, int j, int m, int n, int count){
        if(i>=m || j>=n){
            if(count==m+n-1)
                return 1;
            return 0;
        }
        return getPathCount(i+1, j, m, n, count+1) + getPathCount(i, j+1, m, n, count+1);
    }
    
}