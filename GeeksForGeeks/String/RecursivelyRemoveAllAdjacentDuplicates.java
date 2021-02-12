/*
Question Link: https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0/?track=md-string&batchId=144
Approach: Recursively call functuon with first character and remaining string, check if the char is equal to the first char of remaining string, if no then add it to the string which would be returned in the recursive call.
Also, on finally getting the answer, keep calling the function with updated string until the result is same for 2 consecutive calls. Ex: missippie will become miiie which will become me
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int tc = Integer.parseInt(br.readLine());
    		while(tc-- > 0){
    		    String str = br.readLine();
    		    String res="";
    		    while(true){
    		        res = remDup(str.substring(1, str.length()), str.charAt(0), true);
    		        if(res.length()==0){
    		            System.out.println(res);
    		            break;
    		        }
    		        String str2 = remDup(res.substring(1, res.length()), res.charAt(0), true);
    		        if(res.length()==str.length()){
		                System.out.println(res);
    		            break;
    		        }
    		        str = str2;
    		    }
    		}
	    }
	    catch(Exception e){
	        return;
	    }
	}
	
	public static String remDup(String str, char lastChar, boolean takeLast){
	    if(str.equals(""))
	        return takeLast?Character.toString(lastChar):"";
	    if(str.charAt(0)==lastChar)
	        return remDup(str.substring(1, str.length()), lastChar, false);
        return (takeLast?Character.toString(lastChar):"")+remDup(str.substring(1, str.length()), str.charAt(0), true);
	}
}