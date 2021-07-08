/*
Question Link: https://leetcode.com/problems/decode-string/
Approach: Used recursion, and divided the problem into sub problems
*/
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        res.append(createString(sb));
        return res.toString();
    }
    
    public StringBuilder createString(StringBuilder sb){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            char curr = sb.charAt(i);
            if(curr>='a' && curr<='z')
                res.append(curr);
            else{
                int num = 0;
                while(curr!='['){
                    num=(num*10)+(curr-'0');
                    i++;
                    curr = sb.charAt(i);
                }
                int open = 0;
                int j=i+1;
                while(sb.charAt(j)!=']' || open!=0){
                    if(sb.charAt(j)=='[')
                        open++;
                    if(sb.charAt(j)==']')
                        open--;
                    j++;
                }
                String str = sb.substring(i+1, j);
                res.append(getMultipleString(num, createString(new StringBuilder(str))));
                i=j;
            }
        }
        return res;
    }
    
    public StringBuilder getMultipleString(int n, StringBuilder s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(s);
        return sb;
    }
}