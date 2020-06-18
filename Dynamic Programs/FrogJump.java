/*
Question Link: https://leetcode.com/problems/frog-jump/
Approach: DP
*/
class Solution {
    HashMap<Integer, HashSet<Integer>> notPossible = new HashMap<>();
    public boolean canCross(int[] stones) {
        HashSet<Integer> positions = new HashSet<>();
        for(int i=0; i<stones.length; i++){
            positions.add(stones[i]);
            HashSet<Integer> set = new HashSet<>();
            notPossible.put(stones[i], set);
        }
        return isPossible(stones, 0, 1, positions);
    }
    
    public boolean isPossible(int[] stones, int curr, int jump, HashSet<Integer> positions){
        if(!positions.contains(curr))
            return false;
        if(jump<=0)
            return false;
        if(curr == stones[stones.length-1])
            return true;
        if(notPossible.get(curr).contains(jump))
            return false;
        int next = curr+jump;
        if(!positions.contains(next)){
            notPossible.get(curr).add(jump);
            return false;
        }
        curr = next;
        if(isPossible(stones, curr, jump-1, positions))
           return true;
        else
            notPossible.get(curr).add(jump-1);
        if(isPossible(stones, curr, jump, positions))
           return true;
        else
            notPossible.get(curr).add(jump);
        if(isPossible(stones, curr, jump+1, positions))
           return true;
        else
            notPossible.get(curr).add(jump+1);
        return false;
    }
}