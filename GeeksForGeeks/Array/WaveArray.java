/*
Question Link: https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Swap elements in every pair. All pairs are non interjecting and of consecutive elements.
*/
class Solution{
    public static void convertToWave(int arr[], int n){
        for(int i=0; i+1<n; i+=2){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }
}