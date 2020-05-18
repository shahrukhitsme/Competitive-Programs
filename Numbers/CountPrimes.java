/*
Question Link: https://leetcode.com/problems/count-primes/
Approach: Sieve of eratosthenes
*/
class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        n--;
        boolean[] primes = new boolean[n+1];
        int count=0;
        for(int i=2; i<=n; i++){
            if(primes[i]==true)
                continue;
            count++;
            int j=i*2;
            while(j<=n){
                primes[j]=true;
                j+=i;
            }
        }
        return count;
    }
}