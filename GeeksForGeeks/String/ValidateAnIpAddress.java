/*
Question Link: https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/0/?track=md-string&batchId=144#
Approach: Simple checking but with edge cases
Edge cases: 
0.0.0.0
00.00.00.00
a
111111111111111
0.025.255.255
*/
class Solution 
    public boolean isValid(String s) {
        int numComponent=0;
        int firstDotIndex = -1;
        s=s+'.';
        for(int i=0; i<s.length(); i++){
            if(i-firstDotIndex>4)
                return false;
            if(s.charAt(i)=='.'){
                if(i==firstDotIndex+1)
                    return false;
                int num = Integer.parseInt(s.substring(firstDotIndex+1, i));
                if(num!=0 && s.substring(firstDotIndex+1, i).startsWith("0"))
                    return false;
                if(num==0 && i-firstDotIndex>2)
                    return false;
                if(num<0 || num>255)
                    return false;
                numComponent++;
                firstDotIndex = i;
            }
            else if(s.charAt(i)-'0'<0 || s.charAt(i)-'0'>9)
                    return false;
        }
        if(numComponent!=4)
            return false;
        return true;
    }
}