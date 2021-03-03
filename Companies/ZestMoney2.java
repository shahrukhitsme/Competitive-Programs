/*
There are n buildings in New York City and as a real estate agent you decided to visit some of the buildings every day as follows:
 1 Visit one building.
 2 If the number of remaining buildings (n) is divisible by 2 then you can visit  n/2 buildings.
 3 If the number of remaining buildings (n) is divisible by 3 then you can visit  2*(n/3) buildings.
You can only choose one of the strategies per day.
Return the minimum number of days to visit n buildings.

n=10


visited:   5, 1, 2, 1, 1 
remaining: 5, 4, 2, 1, 0


visited:    1, 6, 2, 1
remaining:  9, 3, 1, 0

answer: 4
*/
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int[] dp;
	public static void main (String[] args) throws java.lang.Exception
	{
	    int input = 10;
	    dp = new int[input+1];
	    for(int i=0; i<=input; i++)
	        dp[i] = -1;
	    int res = getNumOfDay(input);
	    System.out.println(res);
	}
	
	public static int getNumOfDay(int buildings){
	    if(dp[buildings]!=-1)
	        return dp[buildings];
	    if(buildings==0 || buildings==1 || buildings==2){
	        dp[buildings] = buildings;
	    }
	   else if(buildings%3==0){
	        int flow1Remaining = getNumOfDay(buildings-1) +1;
            int flow2Remaining = getNumOfDay(buildings/3) +1;
            dp[buildings] = Math.min(flow1Remaining, flow2Remaining);
	   }
	   else if(buildings%2==0){
	       int flow1Remaining = getNumOfDay(buildings-1) +1;
           int flow2Remaining = getNumOfDay(buildings/2) +1;
           dp[buildings] = Math.min(flow1Remaining, flow2Remaining);
	   }
	   else
	       dp[buildings] = getNumOfDay(buildings-1);
	       
	   return dp[buildings];
	}
}
