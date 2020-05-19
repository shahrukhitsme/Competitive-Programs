/*
Question Link: https://leetcode.com/problems/generate-parentheses/
Approach: Used Recursion. End Case is n=0, in which an empty string is returned. For a length n, the number of combinations will be: "(" + //all strings of length c + ")" + //all strings of length n-c-1, from c = 0, to c = n-1. And adding it to the list.
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n==0)
            return list;
        list.addAll(doit(n, ""));
        return list;
    }
    
    public List<String> doit(int n, String s){
        List<String> temp = new ArrayList<>();
        if(n==0){
            temp.add("");
            return temp;
        }
        for(int c=0; c<n; c++){
            for(String left: doit(c, s)){
                for(String right: doit(n-1-c, s)){
                    temp.add("("+left+")"+right);
                }
            }
        }
        return temp;
    }
}