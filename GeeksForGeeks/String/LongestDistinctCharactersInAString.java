/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0/?track=md-string&batchId=144#
Approach: Used sliding window technique and a boolean array to stroe wheter a character has already occured in the window. If it has, then slide the initial pointer to the point where that character had occured and repeat the process. Update count and max accordingly.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int n = Integer.parseInt(br.readLine());
    		int[] res = new int[n];
    		for(int tc=0; tc<n; tc++){
    		    String str = br.readLine();
    		    res[tc] = getLongestCount(str);
    		}
    		for(int i=0; i<n; i++)
    		    System.out.println(res[i]);
	    }
	    catch(Exception e){
	        return;
	    }
	}
	
	public static int getLongestCount(String str){
	    int max = 0;
	    boolean[] chars = new boolean[256];
	    int i=0, j=0;
	    int currCount = 0;
	    while(j<str.length()){
	        char curr = str.charAt(j);
	        if(!chars[curr]){
	            chars[curr] = true;
	            currCount++;
	            if(currCount>max)
	                max = currCount;
	        }
	        else{
	            while(i<j){
	               currCount--;
	                if(str.charAt(i)==str.charAt(j)){
	                    i++;
	                    break;
	                }
	                chars[str.charAt(i)]=false;
	                i++;
	            }
	            currCount++;
	        }
	        j++;
	    }
	    return max;
	}
}