/*
Question Link: https://leetcode.com/problems/merge-two-binary-trees/
Approach: Just traversed both trees simultaneously with if else conditions.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode result = null;
        if(t1!=null || t2!=null){
            result = new TreeNode();
            merge(t1, t2, result);
        }
        return result;
    }
    
    public void merge(TreeNode t1, TreeNode t2, TreeNode res){
        if(t1==null && t2==null)
            return;
        if(t1==null){
            res.val = t2.val;
            if(t2.left!=null){
                TreeNode temp = new TreeNode();
                res.left = temp;
                merge(null, t2.left, res.left);
            }
            if(t2.right!=null){
                TreeNode temp = new TreeNode();
                res.right = temp;
                merge(null, t2.right, res.right);
            }
        }
        else if(t2==null){
            res.val = t1.val;
            if(t1.left!=null){
                TreeNode temp = new TreeNode();
                res.left = temp;
                merge(null, t1.left, res.left);
            }
            if(t1.right!=null){
                TreeNode temp = new TreeNode();
                res.right = temp;
                merge(null, t1.right, res.right);
            }
        }
        else{
            res.val = t1.val + t2.val;
            if(t1.right!=null || t2.right!=null){
                TreeNode temp = new TreeNode();
                res.right = temp;
                merge(t1.right, t2.right, res.right);
            }
            if(t1.left!=null || t2.left!=null){
                TreeNode temp = new TreeNode();
                res.left = temp;
                merge(t1.left, t2.left, res.left);
            }
        }
    }
}