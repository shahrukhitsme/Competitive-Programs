/*
Question Link: https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Stored dependencies in a hashmap. Key is current task, value is list of dependencies. For each task, we check if dependencies are complete, and if not, we do the same for
each of them. Like this we continue, and if we encounter a cycle, we return false.
*/
class Solution {
    boolean[] isDependent;
    boolean[] completed;
    
    public boolean isPossible(int N, int[][] preArr)
    {
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<>();
        for(int i=0; i<preArr.length; i++){
            if(!pre.containsKey(preArr[i][0]))
                pre.put(preArr[i][0], new ArrayList<Integer>());
            pre.get(preArr[i][0]).add(preArr[i][1]);
        }
        
        isDependent = new boolean[N];
        completed = new boolean[N];
        
        for(int i=0; i<N; i++){
            if(!pre.containsKey(i)){
                completed[i] = true;
                continue;
            }
            if(!completeTasks(i, pre))
                return false;
        }
        return true;
    }
    
    public boolean completeTasks(int curr, HashMap<Integer, ArrayList<Integer>> pre){
        if(!pre.containsKey(curr)){
            completed[curr] = true;
            return true;
        }
        isDependent[curr] = true;
        ArrayList<Integer> dependencies = pre.get(curr);
        for(int i=0; i<dependencies.size(); i++){
            int newTask = dependencies.get(i);
            if(isDependent[newTask])
                return false;
            boolean res = completeTasks(newTask, pre);
            if(!res)
                return false;
        }
        isDependent[curr]=false;
        completed[curr]=true;
        return true;
    }
}