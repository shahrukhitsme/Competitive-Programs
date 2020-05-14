/*
Question Link: https://leetcode.com/problems/roman-to-integer/submissions/
Approach: Brute Force
*/
class Solution {
    public int romanToInt(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int v = getVal(sb.charAt(0));
        int prevVal = v;
        int total = 0;
        int temp = prevVal;
        for(int i=1; i<sb.length(); i++){
            v = getVal(sb.charAt(i));
            if(v == prevVal){
                temp+=v;            
            }
            else if(v < prevVal){
                total += temp;
				temp = v;
			}
            else{
                total -= temp;
				temp = v;
			}
			prevVal = v;
        }
        total += temp;
        return total;
    }
    
    public int getVal(char c){
        switch(c){
            case 'I':
            return 1;
            case 'V':
            return 5;
            case 'X':
            return 10;
            case 'L':
            return 50;
            case 'C':
            return 100;
            case 'D':
            return 500;
            default:
            return 1000;
        }
    }
}