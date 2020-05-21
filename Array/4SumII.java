/*
Question Link: https://leetcode.com/problems/4sum-ii/
Approach: Found all possible combinations of first 2 arrays, and stored the sum along with their frequency in hashmap. Then found all possible combinations of 3rd and 4th arrays, and checked if the negative of that sum is present
in the hashmap. If yes, the freuqency is added to the result.
*/
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int l = A.length, res = 0;
        HashMap<Integer, Integer> AB = new HashMap<>();
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++)
                AB.put(A[i]+B[j],AB.getOrDefault(A[i]+B[j],0)+1);
        }
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++)
                res+=AB.getOrDefault(-1*(C[i]+D[j]), 0);
        }
        return res;
    }
}