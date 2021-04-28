/*
Question Link: https://leetcode.com/problems/zigzag-conversion/
Approach: Found recurring indices for each row, and added characters to final string.
*/
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int succDiff = (numRows*2)-2;
        if(numRows==1 || numRows==2)
            succDiff=numRows;
        for(int i=0; i<numRows; i++){
            int currIndex = i;
            while(currIndex<length){
                sb.append(s.charAt(currIndex));
                if(i>0 && i<numRows-1){
                    int midIndex = currIndex+ 2*(numRows-i-1);
                    if(midIndex>=length)
                        break;
                    sb.append(s.charAt(midIndex));
                }
                currIndex+=succDiff;
            }
        }
        return sb.toString();
    }
}