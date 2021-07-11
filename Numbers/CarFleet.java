/*
Question Link: https://leetcode.com/problems/car-fleet/
Approach: If we need to find the cars that will merge before they reach the end, we need to understand that if a car A is before car B, and takes lesser or equal time to reach target than car B, then they will form a fleet by the time they reach the target.
Now to compare a car with another car having position greater or lesser would be fairly easy if we sort the positions array, and would have stored the speed based on position in a hashmap earlier. Then we just find the time taken by each of them, and from the car closest to target move backwards and compare the current speed with the next car speed and see if they would form a fleet, if they wont, our answer would have one more fleet, and we would continue likewise.
Time complexity: O(NlogN) because of sorting.
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0)
            return 0;
        HashMap<Integer, Integer> mappings = new HashMap<>();
        for(int i=0; i<position.length; i++)
            mappings.put(position[i], speed[i]);
        Arrays.sort(position);
        float[] timeTaken = new float[position.length];
        for(int i=0; i<position.length; i++)
            timeTaken[i] = (float)(target-position[i])/(float)mappings.get(position[i]);
        int res = 0;
        float lastSlowestCarTime = timeTaken[position.length-1]-(float)1;
        for(int i=position.length-1; i>=0; i--){
            float currTime = timeTaken[i];
            if(currTime>lastSlowestCarTime){
                res++;
                lastSlowestCarTime = currTime;
            }
        }
        return res;
    }
}