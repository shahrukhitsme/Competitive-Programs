/*
Question Link: https://leetcode.com/problems/my-calendar-iii/
Approach: Create a map, and at the start index and end index, add and subtract 1 respectively, so that when traversing the map from the beginning, and doing a prefix sum , we would get the current ongoing meetings.
Complexity: O(N*N) for N book calls.
*/
class MyCalendarThree {
    TreeMap<Integer, Integer> changeMap;
    public MyCalendarThree() {
        changeMap = new TreeMap<Integer, Integer>();
    }
    
    public int book(int start, int end) {
        changeMap.put(start, changeMap.getOrDefault(start, 0)+1);
        changeMap.put(end, changeMap.getOrDefault(end, 0)-1);
        
        int max = 0;
        int running = 0;
        for(int key: changeMap.keySet()){
            running += changeMap.get(key);
            if(running > max)
                max = running;
        }
        return max;
    }
    
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */