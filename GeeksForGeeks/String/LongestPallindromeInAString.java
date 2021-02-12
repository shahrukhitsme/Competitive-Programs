/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0/?track=md-string&batchId=144#
Approach: For each character, traverse equally to left and right until the charaters are equal. The maximum such window is the answer. This was for odd length, do the same for even lenght, the only change would be that we have to take 2 characters as centre instead of single.
*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int tc = Integer.parseInt(br.readLine());
    		while(tc-- > 0){
    		    String input = br.readLine();
    		    System.out.println(getLongestPallindrome(input));
    		}
	    }
	    catch(Exception e){
	        return;
	    }
	}
	
	public static String getLongestPallindrome(String str){
	    int len = str.length();
	    int max = 1;
	    String maxString = str.substring(0,1);
	    for(int i=0; i<len; i++){   //for odd length
	        for(int j=0; j<len; j++){
	            if(i-j<0 || i+j>=len)  //edge case
                    break;
	            if(str.charAt(i-j)==str.charAt(i+j) && j+j+1>max){
                    max = j+j+1;
                    maxString = str.substring(i-j, i+j+1);
	            }
	            else if(str.charAt(i-j)!=str.charAt(i+j))
	                break;
	        }
	    }
	    
	    for(int i=0; i<len-1; i++){   //for even length
	        int a=i, b=i+1;
	        if(str.charAt(a)==str.charAt(b)){
	            if(max<2){
	                max = 2;
	                maxString = str.substring(a, b+1);
	            }
	        }
            else
                continue;
	        for(int j=1; j<len; j++){
	            if(a-j<0 || b+j>=len)  //edge case
                    break;
                 if(str.charAt(a-j)==str.charAt(b+j) && j+j+2>max){
                    max = j+j+2;
                    maxString = str.substring(a-j, b+j+1);
	            }
                else if(str.charAt(a-j)!=str.charAt(b+j))
	                break;
	        }
	    }
	    return maxString;
	}
}