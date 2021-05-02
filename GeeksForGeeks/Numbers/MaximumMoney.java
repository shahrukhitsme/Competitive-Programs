/*
Question Link: https://practice.geeksforgeeks.org/problems/maximum-money2855/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: if even then n/2 * K, else (n+1)/2 * K
*/
class Solution {
    static int maximizeMoney(int N , int K) {
        return N%2==0?(N*K)/2:((N+1)*K)/2;
    }
}