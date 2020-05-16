/*
Question Link: https://leetcode.com/problems/count-and-say/submissions/
Approach: Used StringBuilder, and simple bruteforce
*/
class Solution {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        s.append(1);
        StringBuilder temp = new StringBuilder();
        for(int i=2; i<=n; i++){
            char c = s.charAt(0);
            int count = 1;
            for(int j=1; j<s.length(); j++){
                if(s.charAt(j)==c)
                    count++;
                else{
                    temp.append(count).append(c);
                    count = 1;
                    c = s.charAt(j);
                }
            }
            temp.append(count).append(c);
            s = temp;
            temp = new StringBuilder();
        }
        return s.toString();
    }
}