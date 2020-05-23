/*
Question Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Approach: Do a normal recursive traversal, and either add element to start of list, or end of list, based on the current level of the element.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(1, root, res);
        return res;
    }
    
    public void traverse(int level, TreeNode root, List<List<Integer>> res){
        if(root==null)
            return;
        if(res.size()<level)
            res.add(new ArrayList<Integer>());
        if(level%2==0) //left to right
            res.get(level-1).add(0,root.val);
        else
            res.get(level-1).add(root.val);
        traverse(level+1, root.left, res);
        traverse(level+1, root.right, res);
    }
}