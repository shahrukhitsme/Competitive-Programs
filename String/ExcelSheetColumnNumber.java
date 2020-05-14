/*
Question Link: https://leetcode.com/problems/excel-sheet-column-number/
Approach: Brute Force
*/
class Solution {
    public int titleToNumber(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int sum = 0;
        for(int i=sb.length()-1; i>=0; i--)
            sum+=(sb.charAt(i) - 64)*Math.pow(26,sb.length() - i - 1);
        return sum;
    }
}