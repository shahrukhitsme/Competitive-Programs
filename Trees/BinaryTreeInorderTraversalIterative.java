/*
Question Link: https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
Approach: for each node, keep moving left until we reach null, and then print current, and the move to right.
*/
//Iterative
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(!s.empty() || curr!=null){
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}