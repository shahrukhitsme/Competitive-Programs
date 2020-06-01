/*
Question Link: https://leetcode.com/problems/course-schedule/
Approach: Stored all dependents and their dependeicies, in a hashmap of dependent and list of dependencies. Then marked all independent courses as completed. Then traversed through
dependents in hashmap, and recursively their dependencies as dependents, until all are completed. If there is ever a loop, then false is returned. If at last, all courses are marked complete,
return true, else return false.
*/
class Solution {
    int finishCount;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] completed = new boolean[numCourses];
        boolean[] underProgress = new boolean[numCourses];
        finishCount = 0;
        HashMap<Integer, List<Integer>> prerequisiteMap= new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            if(prerequisiteMap.containsKey(prerequisites[i][0]))
                prerequisiteMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                prerequisiteMap.put(prerequisites[i][0], list);
            }
        }
        for(int i=0; i<numCourses; i++){
            if(!prerequisiteMap.containsKey(i)){
                completed[i] = true;
                finishCount++;
            }
        }
        for(int key: prerequisiteMap.keySet()){
            if(!finishCourses(key, prerequisiteMap, completed, underProgress))
                return false;
        }
        return true;
    }
    
    public boolean finishCourses(int key, HashMap<Integer, List<Integer>> prerequisiteMap, boolean[] completed, boolean[] underProgress){
        if(completed[key])
            return true;
        if(underProgress[key] == true)
            return false;
        List<Integer> dependencies = prerequisiteMap.get(key);
        boolean finished = true;
        underProgress[key] = true;
        for(int dependency: dependencies){
            boolean f = finishCourses(dependency, prerequisiteMap, completed, underProgress);
            if(f==false)
                return false;
            finished = finished & f;
        }
        underProgress[key] = false;
        if(finished){
            completed[key] = true;
            finishCount++;
        }
        return finished;
    }
}