/*
Question Link: https://practice.geeksforgeeks.org/problems/print-first-letter-of-every-word-in-the-string3632/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Used stringtokenizer.
*/
class Solution {
    String firstAlphabet(String S) {
        StringTokenizer tk = new StringTokenizer(S, " ");
        StringBuilder sb = new StringBuilder();
        while(tk.hasMoreTokens()){
            sb.append(tk.nextToken().substring(0, 1));
        }
        return sb.toString();
    }
}