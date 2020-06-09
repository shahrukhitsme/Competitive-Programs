/*
Question Link: https://leetcode.com/problems/unique-binary-search-trees/
Approach: Start from length=0, till length=n. For any length, suppose n=10, we have to find all possible trees, considering root as 1, then 2
then 3, till 10. For each, suppose root=4. The left subtree would be of size 3, and right subtree would be of size 6. The possible number of
permutations of n=3 and n=6 would already have been calculated, and we would use that.
*/
class Solution {
    public int numTrees(int n) {
        int[] sol = new int[n+1];
        sol[0] = 1;
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=i; j++){
                count+=sol[j-1]*sol[i-j];
            }
            sol[i]=count;
        }
        return sol[n];
    }
}