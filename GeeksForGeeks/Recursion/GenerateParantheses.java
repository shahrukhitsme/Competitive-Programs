/*
Question Link: https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon#
Approach: Used recursion. At each step, diverged into 2 paths, either closing bracket or opening bracket, by obviously checking if that is valid.
*/
class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> res = new ArrayList<String>();
        recur(res, 0, n, "");
        return res;
    }
    
    public void recur(List<String> res, int open, int remaining, String yet){
        if(remaining==0){
            res.add(yet);
            return;
        }
        if(open>0)
            recur(res, open-1, remaining-1, yet+')');
        if(open<remaining)
            recur(res, open+1, remaining, yet+'(');
    }
}