/*
Question link: https://leetcode.com/problems/diameter-of-binary-tree/
Approach: First setting the value of all nodes to -1. Then, traversing the tree in recursion, and for each node, finding the max depth of left subtree and right subtree, and storing the sum of both
 in the val of that node as the length of max path from it's left subtree to it's right subtree and returning the higher of the two as the max depth of that arm to it's parent node. 
 Also, checking for max each time and updating it. And finally returning max.
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
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        initializeTree(root);
		findMaxArmsLength(root);
		return max;
    }
	
	public void initializeTree(TreeNode root){
		if(root!=null){
			root.val = -1;
			initializeTree(root.left);
			initializeTree(root.right);
		}
	}
	
	public int findMaxArmsLength(TreeNode root){
		if(root != null){
			int temp = 0;
			int leftLength = 0, rightLength = 0;
			if(root.left!=null){
				leftLength = findMaxArmsLength(root.left) + 1;
			}
			if(root.right!=null){
				rightLength = findMaxArmsLength(root.right) + 1;
			}
			temp = leftLength + rightLength;
			root.val = temp;
			if(root.val > max)
				max = root.val;
			return Math.max(leftLength, rightLength);
		}
		return 0;
	}
}