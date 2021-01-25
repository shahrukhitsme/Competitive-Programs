/*
Question Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/0/?track=md-arrays&batchId=144#
Approach: Start from right and keep updating max. Whenever max changes, add it to the list.
*/
class Leader{
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int max = arr[arr.length-1];
        res.add(max);
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i]>=max){
                max = arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}