/*
Question Link: https://leetcode.com/problems/path-sum-iii/
Approach: Create the tree similar to prefix sum array. At each level, pass a hashmap, adding the number, according to it's current value 
which is required to be in it's child, so that the required sum is possible.
While coming up, remove that number.
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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        createPrefixSumTree(root, 0);
        HashMap<Integer, Integer> reqNum = new HashMap<>();
        reqNum.put(sum,1);
        countAllSequences(root, reqNum, sum);
        return count;
    }
    
    public void createPrefixSumTree(TreeNode root, int sumYet){
        if(root==null)
            return;
        root.val = root.val + sumYet;
        createPrefixSumTree(root.left, root.val);
        createPrefixSumTree(root.right, root.val);
    }
    
    public void countAllSequences(TreeNode root, HashMap<Integer, Integer>reqNum, int sum){
        if(root==null)
            return;
        int key = root.val+sum;
        count+=reqNum.getOrDefault(root.val,0);
        reqNum.put(key, reqNum.getOrDefault(key, 0)+1);
        countAllSequences(root.left, reqNum, sum);
        countAllSequences(root.right, reqNum, sum);
        int c = reqNum.get(key);
        if(c==1)
            reqNum.remove(key);
        else
            reqNum.put(key, c-1);
    }
}