/*
Question Link: https://leetcode.com/problems/validate-binary-search-tree/
Approach: Inorder traversal and check if the array is sorted
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
    List<Integer> nums;
    public boolean isValidBST(TreeNode root) {
        nums = new ArrayList<Integer>();
        traverse(root);
        for (int i = 0; i < nums.size()-1; i++) {
            if(nums.get(i)>=nums.get(i+1))
                return false;
        }
        return true;
    }
    
    public void traverse(TreeNode root){
        if(root==null)
            return;
        traverse(root.left);
        nums.add(root.val);
        traverse(root.right);
    }
}