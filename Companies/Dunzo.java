/*
1. Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.
Input: str1 = "abac", str2 = "cab"
Output: "cabac”

acaba cab

cacba

acbab


abcdef
Fbefxd


String LCS(String s1, String s2){
	Int p1 = 0;
	Int p2 = 0;
	String commonString = “”;
	while(p1<s1.length()){	
		String temp = “”;
		Char curr = s1.charAt(p1);
		
		for(;p2<s2.length(); p2++){
			if(s2.charAt(p2)==curr)){
				temp += curr;
				P1++;
				p2++;
}
}
if(temp.length()>commonString.length())
	commonString = temp;
	P1++;
}
return commonString;
}



Q2. Given a list of n integers, find the number of non-empty subsequences such that the product of the values in the subsequences does not exceed K.
1 ≤ N ≤ 30
1 ≤ K, Ai ≤ 10^18
Input format: 
First line contains two space separated integers, N, K.
Second line of the input contains N space separated integers
Sample 1: 
Input:
3 5
1 2 3 
- > 1, 2, 3, 1 2, 1 3
 
Output:
5

1 2 3 4 5 6

8
*/