/*
Question Link: https://leetcode.com/problems/time-based-key-value-store/
Approach: Use a HashMap to store values and timestamps, either use 2 hashmaps of int, string, or a single one with int, object. Then for get, use binary search. Or instead of hashmap use Treemap, and use its properties, floorKey or ceilingKey.
*/
class TimeMap {
    HashMap<String, List<Integer>> timeStamps;
    HashMap<String, List<String>> store;
    /** Initialize your data structure here. */
    public TimeMap() {
        timeStamps = new HashMap<>();
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeStamps.containsKey(key)){
            timeStamps.put(key, new ArrayList<>());
            store.put(key, new ArrayList<>());
        }
        timeStamps.get(key).add(timestamp);
        store.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
            return "";
        int index = findTimeStamp(timestamp, timeStamps.get(key), 0, timeStamps.get(key).size()-1);
        if(index==-1)
            return "";
        return store.get(key).get(index);
    }
    
    public int findTimeStamp(int key, List<Integer> times, int start, int end){
        if(start==end){
            if(key<times.get(start))
                return start-1;
            return start;
        }
        if(start==end-1){
            if(key<times.get(start))
                return start-1;
            if(key>=times.get(end))
                return end;
            return start;
        }
        int mid = (start+end)/2;
        if(key==times.get(mid))
            return mid;
        if(key<times.get(mid))
            return findTimeStamp(key, times, start, mid);
        return findTimeStamp(key, times, mid, end);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */