/*
Question Link: https://leetcode.com/problems/flip-equivalent-binary-trees/
Approach: Traverse the trees recursively and in each call, return the output of recursive calls bby passing child nodes like this: return recur(left, left) && recur(right, right) || recur(left, right) && recur(right, left)
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null || root1.val != root2.val)
            return false;
        
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}