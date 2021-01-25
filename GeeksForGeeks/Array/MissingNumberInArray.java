/*
Question Link: https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1/?track=md-arrays&batchId=144
Approach: (sum of all numbers till n) - (sum of all integers in array)
Could be done using XOR also. XOR of all numbers till n XOR of all integers is the answer. Becasue all others will get nullified.
*/
class Solution {
    int MissingNumber(int array[], int n) {
        int sum = 0;
        for(int val: array)
            sum+=val;
        int expected = (n * (n+1))/2;
        return expected-sum;
    }
}