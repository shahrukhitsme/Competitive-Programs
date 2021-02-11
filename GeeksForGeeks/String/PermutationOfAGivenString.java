/*
Question Link: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0/?track=md-string&batchId=144#
Approach: Used recursion. And kept a hashset to keep track of unique permutations, and sorted the strin gin the beginning to get all permutations in lexicographically increasing order.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static HashSet<String> set;
	public static void main (String[] args) {
	    try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int t = Integer.parseInt(br.readLine());
    		while(t-- > 0){
    		    String input = br.readLine();
    		    char[] chars = input.toCharArray();
                Arrays.sort(chars);
                input = new String(chars);
    		    set = new HashSet<String>();
    		    printPerm(input, "");
    		    System.out.println();
    		}
	    }
	    catch(Exception e){
	        return;
	    }
	}
	
	public static void printPerm(String input, String yet){
	    if(input.length() == 0){
	        if(!set.contains(yet)){
	            System.out.print(yet+" ");
	            set.add(yet);
	        }
	    }
	   else{
	       for(int i=0; i<input.length(); i++){
	           printPerm(input.substring(0,i)+input.substring(i+1, input.length()), yet+input.charAt(i));
	       }
	   }
	}
}