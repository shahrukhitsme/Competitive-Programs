/*
Question Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/
Approach: Add manager to list of subordinate entries in hashmap. Made a recursive function which will take a person as input and return time taken by him and his subordinates to inform. Called the function with the head of the organization. Recursively went to its subordinates and called for each of them. The most time taken amongst them will be the time taken by his subordinates so add his time to it and return.
*/
class Solution {
    HashMap<Integer, List<Integer>> mp;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        mp = new HashMap<>();
        for(int i=0; i<manager.length; i++){
            int managerIndex = manager[i];
            if(mp.containsKey(managerIndex))
                mp.get(managerIndex).add(i);
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                mp.put(managerIndex, temp);
            }
        }
        return inform(mp.get(-1).get(0), informTime);
    }
    
    public int inform(int key, int[] informTime){
        int t = 0;
        if(!mp.containsKey(key))
            return 0;
        t+=informTime[key];
        List<Integer> subs = mp.get(key);
        int tt = 0;
        for(int i=0; i<subs.size(); i++){
            int sub = subs.get(i);
            int time = inform(sub, informTime);
            if(time>tt)
                tt=time;
        }
        t+=tt;
        return t;
    }
}