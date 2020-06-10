/*
Question Link: https://leetcode.com/problems/gas-station/
Approach: The main idea is that every time we go to the next station as far as possible (remained gas is bigger or equal to 0) until we can not (remained gas is less than 0).
Then we must extend our start station to the "last station" ( the station before start station) to find a possible solution.
Repeat these two steps until we have checked all stations(start == end).
The edge cases are handled by taking start at last index, and end at zeroth index.
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] balance = new int[gas.length];
        for(int i=0; i<gas.length; i++)
            balance[i] = gas[i] - cost[i];
        int start = gas.length-1, end = 0;
        int sum = balance[start];
        while(end<start){
            if(sum>=0){
                sum+=balance[end];
                end++;
            }else{
                start--;
                sum+=balance[start];
            }
        }
        return sum>=0?start:-1;
    }
}