/*
Question Link: https://leetcode.com/problems/top-k-frequent-elements/
Approach: Bucket Sort. Create an array of list of size of input array. Calculate all frequencies in a HashMap. Insert the element at the index of it's frequency. Finally, get max K elements from that array.
*/
class Solution {
    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] bucket = new List[numbers.length+1];
        for(int i=0; i<numbers.length; i++)
            freq.put(numbers[i], freq.getOrDefault(numbers[i], 0)+1);
        for(int key: freq.keySet()){
            int frequency = freq.get(key);
            if(bucket[frequency]==null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=numbers.length; i>=0 && res.size()<=k; i--){
          if(bucket[i]!=null)
              res.addAll(bucket[i]);
        }
        int[] result = new int[k];
        for(int i=0; i<k; i++)
            result[i] = res.get(i);
        return result;
    }
}