/*
Question Link: https://leetcode.com/problems/pascals-triangle/submissions/
Approach: Brute Force(Runtime: 0ms)
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0)
            return res;
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        res.add(inner);
        if(numRows==1)
            return res;
        inner = new ArrayList<>();
        inner.add(1);
        inner.add(1);
        res.add(inner);
        for(int i=3; i<= numRows; i++){
            inner = new ArrayList<>();
            int mid = (i+1)/2;
            inner.add(1);
            inner.add(i-1);
            for(int j=2; j<mid; j++){
                inner.add(res.get(i-2).get(j)+res.get(i-2).get(j-1));
            }
            int repeatIndex;
            if(i%2==0)
                repeatIndex = mid-1;
            else
                repeatIndex = mid-2;
            for(int j=repeatIndex; j>=0; j--)
                inner.add(inner.get(j));
            res.add(inner);
        }
        return res;
    }
}