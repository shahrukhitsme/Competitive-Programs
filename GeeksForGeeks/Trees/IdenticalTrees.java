/*
Question Link: https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/0/?track=md-tree&batchId=144
Approach: Recursion, checking if data of current node of both trees are equal and then recursively called the same method of their left child and right child.
*/
class Tree
{
	boolean isIdentical(Node root1, Node root2)
	{
	   if(root1==null && root2==null) return true;
	   if(root1==null || root2==null) return false;
	   if(root1.data!=root2.data) return false;
	   return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}
	
}