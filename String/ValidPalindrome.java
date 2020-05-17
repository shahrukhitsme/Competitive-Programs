/*
Question Link: https://leetcode.com/problems/valid-palindrome/submissions/
Approach: Just checking from front and back using 2 pointers, and keep updating the pointers until an alphanumeric value is reached. This continues until they cross each other.
*/
class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        char l, r;
        while(i<j){
            l=s.charAt(i);
            r=s.charAt(j);
            while(!isAlphanumeric(l)){
                i++;
                if(i>=s.length())
                    break;
                l=s.charAt(i);
            }
            while(!isAlphanumeric(r)){
                j--;
                if(j<0)
                    break;
                r=s.charAt(j);
            }
            if(i>=j)
                break;
            if(Character.toLowerCase(l) != Character.toLowerCase(r))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        if((c>='A'&&c<='Z') || (c>='a'&&c<='z') || (c>='0'&&c<='9'))
            return true;
        return false;
    }
}