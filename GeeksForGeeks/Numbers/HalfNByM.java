/*
Question Link: https://practice.geeksforgeeks.org/problems/geek-and-coffee-shop5721/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Just Halved M-1 times
*/
class Solution{
    static int mthHalf(int N, int M){
        while(--M > 0 && N > 0) 
        N = N/2;
        return N;
    }
}