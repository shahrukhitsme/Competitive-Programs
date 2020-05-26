/*
Question Link:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
Approach: Used HashMap and recursion, but a better approach is commented.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, Boolean> foundP = new HashMap<>();
    HashMap<TreeNode, Boolean> foundQ = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundP = new HashMap<>();
        foundQ = new HashMap<>();
        if(root==null)
            return null;
        return fillFoundOrNot(root, p, q);
    }
    
    public TreeNode fillFoundOrNot(TreeNode root, TreeNode p, TreeNode q){
        foundP.put(root, root==p);
        foundQ.put(root, root==q);
        if(root.left!=null){
            TreeNode temp = fillFoundOrNot(root.left, p, q);
            if(temp!=null)
                return temp;
            if(foundP.get(root.left))
                foundP.put(root, true);
            if(foundQ.get(root.left))
                foundQ.put(root, true);
        }
        if(root.right!=null){
            TreeNode temp = fillFoundOrNot(root.right, p, q);
            if(temp!=null)
                return temp;
            if(foundP.get(root.right))
                foundP.put(root, true);
            if(foundQ.get(root.right))
                foundQ.put(root, true);
        }
        if(foundP.get(root) && foundQ.get(root))
            return root;
        return null;
    }
}

/* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
} */