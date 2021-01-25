/*
Question Link: https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/0/?track=md-arrays&batchId=144#
Approach: Maintained an array which kept numOfZeroesYet-numOfOnesYet. Then in that array, I need those 2 indexes which are farthest
apart, and have the same value. So, I use a hashmap for that. I add the value as key and index as value to hashmap, if it is not there already.
If the value is already present as a key, I find the difference in its current index position and the one in the hashmap and update max.
Also, whenever there is a 0 in the array, the max shall be checked with the lenght of subarray from 0 index till that index.
Finally return max.
*/
class GfG {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        int max = 0;
        int[] diff = new int[N];
        if(arr[0]==0)
            diff[0]=1;
        else
            diff[0]=-1;
        for(int i=1; i<N; i++){
            if(arr[i]==0)
                diff[i]=diff[i-1]+1;
            else
                diff[i]=diff[i-1]-1;
            if(diff[i]==0)
                max=i+1;
        }
        HashMap<Integer, Integer> positions = new HashMap<>();
        for(int i=0; i<diff.length; i++){
            int key = diff[i];
            if(positions.containsKey(key) && i-positions.get(key)>max)
                max=i-positions.get(key);
            else if(!positions.containsKey(key))
                positions.put(key, i);
        }
        return max;
    }
}