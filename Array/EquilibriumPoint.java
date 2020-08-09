/*
Question Link: https://practice.geeksforgeeks.org/problems/equilibrium-point/0
Approach: Calculate total sum. Then again start traversing and keep adding sum, and when left sum is half of total sum - current index value, that is the equilibrium point.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++){
		    int n = Integer.parseInt(br.readLine());
		    int[] arr = new int[n];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=0; i<n; i++)
		        arr[i]=Integer.parseInt(st.nextToken());
		     System.out.println(findEquilibrium(arr));
		}
	}
	
	public static int findEquilibrium(int[] arr){
	    int sum=0;
	    for(int i=0; i<arr.length; i++)
	        sum+=arr[i];
	    int leftSum=0;
	    for(int i=0; i<arr.length; i++){
	        if(leftSum*2+arr[i] == sum)
	            return i+1;
	        leftSum+=arr[i];
	    }
	    return -1;
	}
}