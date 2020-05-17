/*
Question Link: https://leetcode.com/problems/valid-parentheses/
Approach: Used a stack. When you encounter a closing bracket, the popped character must be the equivalent opening bracket.
*/
class Solution {
    public boolean isValid(String st) {
        StringBuilder str = new StringBuilder();
        str.append(st);
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(']','[');
        pairs.put('}','{');
        pairs.put(')','(');
        char c;
        for(int i=0; i<str.length(); i++){
            c = str.charAt(i);
            if(c=='{'||c=='['||c=='(')
                s.push(c);
            else if(s.size()==0 || s.pop()!=pairs.get(c))
                return false;
        }
        return s.size()==0;
    }
}