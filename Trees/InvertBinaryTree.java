/*
Question Link: https://leetcode.com/problems/invert-binary-tree/
Approach: Traverse each node, and swap it's left and right child.
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
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public void traverse(TreeNode root){
        if(root!=null){
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            traverse(root.left);
            traverse(root.right);
        }
    }
}