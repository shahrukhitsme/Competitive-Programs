/*
Question Link: https://leetcode.com/problems/all-possible-full-binary-trees/
Approach: Used recursion to generate all possbile combinations of subtrees, and used backtracking to generate list of roots with combinations of left and right. Also stored the list of trees for a particular n in a hashmap.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    HashMap<Integer, List<TreeNode>> mp = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        int num = n;
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        if(n%2==0 || n<0)
            return res;
        if(n==1){
            res.add(new TreeNode(0));
            return res;
        }
        n--;
        n-=2;
        for(int i=0; i<=n; i=i+2){
            List<TreeNode> left = allPossibleFBT(i+1);
            List<TreeNode> right = allPossibleFBT(n-i+1);
            List<TreeNode> roots = new ArrayList<>();
            for(int j=0; j<left.size(); j++){
                for(int k=0; k<right.size(); k++){
                    TreeNode temp = new TreeNode(0);
                    temp.left = left.get(j);
                    temp.right = right.get(k);
                    roots.add(temp);
                }
            }
            res.addAll(roots);
        }
        mp.put(num, res);
        return res;
    }
}