/*
Question Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Approach: Recursively, keep dividing the inorder array, into left and right subtrees, based on the preorder array.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, inorder, 0, 0, inorder.length-1);
        return root;
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int p, int iL, int iR){
        if(p>=preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[p]);
        int i;
        for(i=iL; i<=iR; i++){
            if(inorder[i]==root.val)
                break;
        }
        if(i>iL){
            root.left = build(preorder, inorder, p+1, iL, i-1);
        }
        else
            root.left = null;
        if(i<iR){
            root.right = build(preorder, inorder, p+i-iL+1, i+1, iR);
        }
        else
            root.right = null;
        return root;
    }
}