/*
Question Link: https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/0/?track=md-tree&batchId=144#
Approach: Use Recursion. For each node, check if it has both left and right child, return minimum of the two heights, else if it has only one child, return its height, else if it
has no child return 1
*/
class Tree
{
	int minDepth(Node root)
	{
	    if(root==null) return 0;
	    if(root.left==null && root.right==null) return 1;
	    if(root.left==null) return minDepth(root.right)+1;
	    if(root.right==null) return minDepth(root.left)+1;
	    return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
}