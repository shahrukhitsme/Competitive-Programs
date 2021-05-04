/*Given a list of strings, string a, string b, find the number of occurences of b in each string in the list, and replace them with c*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    ArrayList<String> arr = new ArrayList<>();
	    arr.add("peterjppeter");
	    arr.add("what peter even is this");
	    arr.add("peter is my name");
	    arr.add("I have no name");
	    arr.add("peterrrr");
	    arr.add("pppeeetter");
	    arr.add("ppeterrrr");
	    arr.add("peterpeter");
	    String b = "peter";
	    String c = "sam";
	    ArrayList<ArrayList<String>> res = operate(arr, b, c);
	    for(int i=0; i<res.size(); i++)
	        System.out.println(res.get(i).get(0)+" "+res.get(i).get(1));
	}
	
	public static ArrayList<ArrayList<String>> operate(ArrayList<String> arr, String b, String c){
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    for(int i=0; i<arr.size(); i++){
	        String currString = arr.get(i);
	        int len = b.length();
	        int numOfOccurences = 0;
	        int index = currString.indexOf(b);
	        while(index!=-1){
	            String leftSub = currString.substring(0, index);
	            String rightSub;
	            if(index+len>=currString.length())
	                rightSub = "";
	            rightSub = currString.substring(index+len);
	            currString = leftSub + c + rightSub;
	            numOfOccurences++;
	            index = currString.indexOf(b);
	        }
	        ArrayList<String> tuple = new ArrayList<>();
	        tuple.add(Integer.toString(numOfOccurences));
	        tuple.add(currString);
	        res.add(tuple);
	    }
	    return res;
	}
}


/*Insert an element in a sorted list in O(logn)*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(5);
		insert(3, arr);
		System.out.println(arr);
	}
	
	public static void insert(int elem, ArrayList<Integer> arr){
	    int indexToBeInsertedAt = findPosition(arr, 0, arr.size()-1, elem);
	    arr.add(indexToBeInsertedAt, elem);
	}
	
	public static int findPosition(ArrayList<Integer> arr, int start, int end, int elem){
	    int mid = (start+end)/2;
	    int midElem = arr.get(mid);
	    if(elem>midElem){
	        if(mid==end)
	            return mid;
	       if(elem<arr.get(mid+1))
	            return mid+1;
            return findPosition(arr, mid+1, end, elem);
	    }
	    else
	        return findPosition(arr, start, mid-1, elem);
	}
}
