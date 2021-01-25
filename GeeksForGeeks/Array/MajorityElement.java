/*
Question Link: https://practice.geeksforgeeks.org/problems/majority-element-1587115620/0/?track=md-arrays&batchId=144
Approach 1: Used to hashmap to store count and also update max during iteration. O(n), O(n)
Approach 2: Moore voting algorithm. O(n), O(1)
*/
class Majority
{
    static int majorityElement(int a[], int size)
    {
        /*
        //Approach 1:
        HashMap<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        int maxOcc = -1;
        for(int i:a){
            mp.put(i, mp.getOrDefault(i, 0)+1);
            if(mp.get(i)>max){
                max=mp.get(i);
                maxOcc = i;
            }
        }
        if(max>size/2)
            return maxOcc;
        return -1;
        */
        //Approach 2:
        int count = 1;
        int candidate = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]==candidate)
                count++;
            else
                count--;
            if(count==0){
                candidate=a[i];
                count=1;
            }
        }
        int numOfOcc = 0;
        for(int i:a){
            if(i==candidate)
                numOfOcc++;
        }
        if(numOfOcc>a.length/2)
            return candidate;
        return -1;
    }
}