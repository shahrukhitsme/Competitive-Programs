/*
Question Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
Approach: Used Recursion, and passed level as parameter. Used level to add the current level val to the list of lists.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        doit(0, root, res);
        return res;
    }
    
    public void doit(int level, TreeNode root, List<List<Integer>> res){
        if(root==null)
            return;
        if(level>=res.size())
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        }
        else
            res.get(level).add(root.val);
        doit(level+1, root.left, res);
        doit(level+1, root.right, res);
    }
}