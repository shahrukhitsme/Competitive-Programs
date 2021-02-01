/*
Question Link: https://practice.geeksforgeeks.org/problems/pascal-triangle0652/0/?track=md-recursion&batchId=144#
Approach: Recursion by sending each row in the recursive call and creating the next row.
*/
class Solution {
    Vector<Long> nthRowOfPascalTriangle(int n) {
        Vector<Long> res = new Vector<>();
        res.add(0, (long)1);
        if(n>1)
            res.add(0,(long)1);
        return createRow(res, n-1);
    }
    
    Vector<Long> createRow(Vector<Long> res, int n){
        if(n<=1)
            return res;
        Vector<Long> res2 = new Vector<>();
        res2.add(0, (long)1);
        long m = 1000000007;
        for(int i=1; i<res.size(); i++)
            res2.addElement((res.get(i)%m+res.get(i-1)%m)%m);
        res2.addElement((long)1);
        return createRow(res2, n-1);
    }
}