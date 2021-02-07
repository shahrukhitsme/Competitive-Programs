/*
Question Link: https://practice.geeksforgeeks.org/problems/implement-atoi/0/?track=md-string&batchId=144
Approach: Traversing the string with some edge case conditions:
    checking preceeding zeroes
    checking if the number is negative
    checking for any num numeric character
*/
class GfG
{
    int atoi(String s)
    {
	    int i = 0;
	    boolean isNegative = false;
	    if(s.charAt(i)=='-'){
	        isNegative = true;
	        i++;
	    }
	    int len = s.length();
	    while(i<len){
	        if(s.charAt(i)!='0')
	            break;
	       i++;
	    }
	    int res = 0;
	    while(i<len){
	        int num = s.charAt(i)-'0';
	        if(num<0 || num>9)
	            return -1;
	        res = (res*10)+num;
	       i++;
	    }
	    if(isNegative)
	        res*=-1;
	    return res;
    }
}