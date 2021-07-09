/*
Question Link: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
Approach: Store number of unique characters from end to a particular index for both forward and backward pass in 2 arrays. Then in a single traversal, compare number of unique characters on left with that on right for each partition, and increment the result accordingly.
*/
class Solution {
    public int numSplits(String str) {
        StringBuilder s = new StringBuilder(str);
        HashMap<Character, Boolean> occurencesL2R = new HashMap<>();
        HashMap<Character, Boolean> occurencesR2L = new HashMap<>();
        int[][] occ = new int[2][s.length()];
        occ[0][0] = 1;
        occurencesL2R.put(s.charAt(0), true);
        occurencesR2L.put(s.charAt(s.length()-1), true);
        occ[1][s.length()-1] = 1;
        for(int i=1; i<s.length(); i++){
            int j = s.length()-1-i;
            char cL = s.charAt(i);
            char cR = s.charAt(j);
            if(!occurencesL2R.getOrDefault(cL,false)){
                occurencesL2R.put(cL, true);
                occ[0][i] = occ[0][i-1]+1;
            }else{
                occ[0][i] = occ[0][i-1];
            }
            
            if(!occurencesR2L.getOrDefault(cR,false)){
                occurencesR2L.put(cR, true);
                occ[1][j] = occ[1][j+1]+1;
            }else{
                occ[1][j] = occ[1][j+1];
            }
        }
        
        int res = 0;
        for(int i=0; i<s.length()-1; i++){
            if(occ[0][i]==occ[1][i+1])
                res++;
        }
        return res;
    }
}