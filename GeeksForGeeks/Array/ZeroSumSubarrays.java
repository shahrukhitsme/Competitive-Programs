/*
Question Link: https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1#
Approach: Kept summing each number, and kept storing the sum's occurence in a hashmap. If a sum has occurred more than once, then the sum of elements in between it's occurences is 0.
Suppose sum was 3 twice, then there exists a subarray in between those 2 occurences whose sum is 0.
Suppose sum was 4 thrice, then there exists 3 subarrays in between those 3 occurences whose sum is 0.
*/
public static int findSubarray(int[] arr ,int n) 
{
    HashMap<Integer,Integer> mp = new HashMap<>();
    int sum=0;
    mp.put(0, 1);
    for(int i=0; i<n; i++){
        sum+=arr[i];
        mp.put(sum, mp.getOrDefault(sum, 0)+1);
    }
    int count=0;
    for(int key:mp.keySet()){
        int val = mp.get(key);
        if(val>1){
            count+=getRes(val-1);
        }
    }
    return count;
}

public static int getRes(int n){
    if(n<=1)
        return n;
    return n+getRes(n-1);
}