/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/0/?track=md-string&batchId=144#
Approach: binary search the index
*/
class Solution{
    String longestCommonPrefix(String arr[], int n){
        if(arr.length==0)
            return "-1";
        int minLen = arr[0].length();
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()<minLen)
                minLen=arr[i].length();
        }
        //System.out.println("minLen: "+minLen);
        int i = binarySearch(arr, 0, minLen-1);
        //System.out.println("i: "+i);
        if(!check(arr, i))
            return "-1";
        return arr[0].substring(0, i+1);
    }
    
    int binarySearch(String arr[], int a, int b){
        //System.out.println("a b: "+a+" "+b);
        if(b==a){
            return b;
        }
        if(b==a+1){
            if(check(arr, b))
                return b;
            return a;
        }
        int mid = (a+b)/2;
        if(check(arr, mid))
            return binarySearch(arr, mid, b);
        else
            return binarySearch(arr, a, mid-1);
    }
    
    boolean check(String arr[], int index){
        String prefix = arr[0].substring(0, index+1);
        //System.out.println(index+" "+prefix);
        for(int i=0; i<arr.length; i++){
            if(!arr[i].substring(0, index+1).equals(prefix))
                return false;
        }
        return true;
    }
}