/*
Question Link: https://practice.geeksforgeeks.org/problems/check-set-bits5408/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: if all bits are set, then it is 1 less than a power of 2. So checked that only.
*/
//User function Template for Java
class Solution{
    static int isBitSet(int N){
        N++;
        while(N!=1){
            if(N%2!=0)
                return 0;
            N/=2;
        }
        return 1;
    }
}