/*
Question Link: https://leetcode.com/problems/find-duplicate-subtrees/
Approach: Traversed the tree and stores the references of nodes according to value in HashMap, and traversed again then found all nodes with matching values, and compared them and also stored the comparison result in hashmap dp, for O(1) comparison next time, and if comparison result is true, added it to the result list.
Better Approach: Do a inorder traveral, and keep creating inrder searialized string and store in hashmap as key, with value pointing to the root node for that inorder string. Then finally just get the entries from the hashmap which have more than 1 node.
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
    HashMap<Integer, HashSet<TreeNode>> map;
    HashMap<TreeNode, HashSet<TreeNode>> dp;
    HashMap<TreeNode, HashSet<TreeNode>> dp2;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        dp = new HashMap<>();
        dp2 = new HashMap<>();
        res = new ArrayList<>();
        updateMap(root);
        traverse(root);
        return res;
    }
    
    public void traverse(TreeNode root){
        if(root==null || !map.containsKey(root.val))
            return;
        int val = root.val;
        HashSet<TreeNode> nodes = map.get(val);
        boolean clone = false;
        List<TreeNode> nodesToRemove = new ArrayList<>();
        for(TreeNode node: nodes){
            if(node!=root){
                if(compareTrees(root, node)){
                    clone = true;
                    nodesToRemove.add(node);
                }
            }
        }
        if(clone){
            for(int i=0; i<nodesToRemove.size(); i++){
                map.get(val).remove(nodesToRemove.get(i));
            }
            map.get(val).remove(root);
            res.add(root);
        }
        traverse(root.left);
        traverse(root.right);
    }
    
    public void updateMap(TreeNode root){
        if(root==null)
            return;
        int val = root.val;
        if(!map.containsKey(val))
            map.put(val, new HashSet<>());
        map.get(val).add(root);
        updateMap(root.left);
        updateMap(root.right);
    }
    
    public boolean compareTrees(TreeNode node1, TreeNode node2){
        if(node1==node2)
            return true;
        if(node1==null || node2==null)
            return false;
        if(dp.containsKey(node1) && dp.get(node1).contains(node2))
            return true;
        if(dp2.containsKey(node1) && dp2.get(node1).contains(node2))
            return false;
        if(node1.val!=node2.val)
            return false;
        if(compareTrees(node1.left, node2.left) && compareTrees(node1.right, node2.right)){
            if(!dp.containsKey(node1)){
                dp.put(node1, new HashSet<TreeNode>());
            }
            if(!dp.containsKey(node2)){
                dp.put(node2, new HashSet<TreeNode>());
            }
            dp.get(node1).add(node2);
            dp.get(node2).add(node1);
            return true;
        }
        if(!dp2.containsKey(node1)){
            dp2.put(node1, new HashSet<TreeNode>());
        }
        if(!dp2.containsKey(node2)){
            dp2.put(node2, new HashSet<TreeNode>());
        }
        dp2.get(node1).add(node2);
        dp2.get(node2).add(node1);
        return false;
    }
}