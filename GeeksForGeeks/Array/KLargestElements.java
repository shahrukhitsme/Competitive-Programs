/*
Question Link: https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Used PriorityQueue
*/
class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++)
            pq.add(arr[i]);
        for(int i=0; i<k; i++)
            res.add(pq.poll());
        return res;
    }
}