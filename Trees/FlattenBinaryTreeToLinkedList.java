/*
Question Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Approach: Used recursion, after calling flatten function for both left and right, put left subtree in between root and root.right
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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        if(root.left!=null)
            flatten(root.left);
        if(root.right!=null)
            flatten(root.right);
        if(root.left==null)
            return;
        TreeNode temp = root.left;
        while(temp.right!=null)
            temp = temp.right;
        temp.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}