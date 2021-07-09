/*
Question Link: https://leetcode.com/problems/delete-nodes-and-return-forest/
Approach: Store references and parent nodes in hashmaps so that when deleting we can get the references in constant time. Then traverse the list of nodes to delete, and for each of them, add it's left and right child as new trees in the set, and if it itself exists in the set, remove it, and remove it's reference from it's parent.
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> trees = new ArrayList<>();
        HashMap<Integer, TreeNode> refs = new HashMap<>();
        HashMap<Integer, TreeNode> parent = new HashMap<>();
        updateRefs(refs, parent, root, null);
        HashSet<TreeNode> set = new HashSet<>();
        set.add(root);
        for(int i=0; i<to_delete.length; i++){
            int nodeVal = to_delete[i];
            TreeNode delNode = refs.get(nodeVal);
            TreeNode parentNode = parent.get(nodeVal);
            if(delNode.left!=null)
                set.add(delNode.left);
            if(delNode.right!=null)
                set.add(delNode.right);
            if(set.contains(delNode))
                set.remove(delNode);
            if(parentNode!=null){
                if(parentNode.left!=null && parentNode.left.val==delNode.val)
                    parentNode.left = null;
                else
                    parentNode.right = null;
            }
        }
        for(TreeNode t: set)
            trees.add(t);
        return trees;
    }
    
    public void updateRefs(HashMap<Integer, TreeNode> refs, HashMap<Integer, TreeNode> parent, TreeNode root, TreeNode parentNode){
        if(root==null)
            return;
        refs.put(root.val, root);
        parent.put(root.val, parentNode);
        updateRefs(refs, parent, root.left, root);
        updateRefs(refs, parent, root.right, root);
    }
}