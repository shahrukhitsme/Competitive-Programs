/*
Question Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
Approach: Solve recursivly. Keep middle element of array as root, and to it's left would be the left side of the array, and to it's right would be the right side of the array.
So, both would be again passed to the recursive function.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(0, nums.length-1, nums);
    }
    
    public TreeNode createBST(int l, int r, int[] nums){
        if(l>r)
            return null;
        int m = (l+r+1)/2;
        TreeNode root = new TreeNode(nums[m]);
        if(l==r)
            return root;
        root.left = createBST(l, m-1, nums);
        root.right = createBST(m+1, r, nums);
        return root;
    }
}