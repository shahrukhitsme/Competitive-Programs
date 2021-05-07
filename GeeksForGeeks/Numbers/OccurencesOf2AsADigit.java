/*
Question Link: https://practice.geeksforgeeks.org/problems/occurences-of-2-as-a-digit/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon
Approach: Constraint of N is 100000. 
For every 10, number of 2 is 1
For every 100, number of 2 is 20
For every 1000, number of 2 is 300
For every 10000, number of 2 is 4000
For every 100000, number of 2 is 50000
We use this, and have edge cases for scenraios, where we have to count till a number which starts with 2.
Like from 20 to 29, 200 to 299, 2000 to 2999, and so on.
*/
class GfG
{
    public static long count2s(long n)
    {
        long count_1 = 1;
        long count_2 = 20;
        long count_3 = 300;
        long count_4 = 4000;
        long count_5 = 50000;
        long res = 0;
        res += (n/100000)*count_5;
        if(n>299999)
            res+=100000;
        else if(n>200000)
            res+=n-199999;
        n=n%100000;
        res += (n/10000)*count_4;
        if(n>29999)
            res+=10000;
        else if(n>20000)
            res+=n-19999;
        n=n%10000;
        res += (n/1000)*count_3;
        if(n>2999)
            res+=1000;
        else if(n>2000)
            res+=n-1999;
        n=n%1000;
        res += (n/100)*count_2;
        if(n>299)
            res+=100;
        else if(n>200)
            res+=n-199;
        n=n%100;
        res += (n/10)*count_1;
        if(n>29)
            res+=10;
        else if(n>20)
            res+=n-19;
        n=n%10;
        if(n>=2)
            res++;
        return res;
    }