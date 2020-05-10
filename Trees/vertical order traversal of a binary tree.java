/*
Question Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
Approach: I have first counted the number of vertical lines possible and the height of the tree
			Then, created a list of lists. Outer list of length = number of vertical lines. Because, that is what we need to output.
			I traverse the tree, and pass down the coordinate information, and also in each recursive call, calculate the position in the list of lists, based on the coordinates
			I also keep a 2D array XnY updated with the number of overlapping nodes at position X and Y. This will help me in finding the correct range of index which is applicable
			 for a particular element in a vertical Line list(inner list), so that I can enter the value in sorted order.
			 And thus the whole tree is traversed.
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
    List<List<Integer>> res;
	int leftMostIndex, rightMostIndex;
	int[][] XnY;
    
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		if(root==null)
			return null;
		res = new ArrayList<>();
		leftMostIndex = getSideMostIndex(root, 0, true);
		rightMostIndex = getSideMostIndex(root, 0, false);
		int totalVerticalLines = rightMostIndex - leftMostIndex + 1;
		int heightOfTree = getHeight(root, 0);
		XnY = new int[totalVerticalLines][heightOfTree];
		for(int i=0; i<totalVerticalLines; i++){
			List<Integer> temp = new ArrayList<>();
			res.add(temp);
		}
		traverse(root, 0, 0);
		return res;
	}

    public int getSideMostIndex(TreeNode root, int currLeft, boolean findLeft){
        int leftMostIndex1 = currLeft, leftMostIndex2 = currLeft;
        if(root.left!=null)
            leftMostIndex1 = getSideMostIndex(root.left, currLeft-1, findLeft);
        if(root.right!=null)
            leftMostIndex2 = getSideMostIndex(root.right, currLeft+1, findLeft);
        if(findLeft)
            return Math.min(leftMostIndex1, leftMostIndex2);
        return Math.max(leftMostIndex1, leftMostIndex2);
    }
	
	public int getHeight(TreeNode root, int currHeight){
		if(root==null)
			return currHeight;
		return Math.max(getHeight(root.left, currHeight+1), getHeight(root.right, currHeight+1));
	}
    
    public void traverse(TreeNode root, int X, int Y){
		if(root==null)
			return;
		int xIndex = X - leftMostIndex;
		int yIndex = 0 - Y;
		List<Integer> VerticalLineAtX = res.get(xIndex);
		int numOfElemsYetInCurrLine = 0, numOfElemsAheadInCurrLine = 0;
		for(int i=0; i<yIndex; i++)
			numOfElemsYetInCurrLine += XnY[xIndex][i];
		for(int i=yIndex+1; i<XnY[xIndex].length; i++)
			numOfElemsAheadInCurrLine += XnY[xIndex][i];
		boolean inserted = false;
		if(xIndex == 5)
		{
			System.out.println(root.val+ " " +numOfElemsYetInCurrLine+" "+VerticalLineAtX.size()+" "+numOfElemsAheadInCurrLine);
		}
		for(int i=numOfElemsYetInCurrLine; i<VerticalLineAtX.size()-numOfElemsAheadInCurrLine; i++){
			if(root.val<VerticalLineAtX.get(i)){
				VerticalLineAtX.add(i, root.val);
				inserted = true;
				break;
			}
		}
		if(!inserted)
			VerticalLineAtX.add(numOfElemsYetInCurrLine+XnY[xIndex][yIndex], root.val);
		XnY[xIndex][yIndex] = XnY[xIndex][yIndex]+1;
		res.set(xIndex, VerticalLineAtX);
		traverse(root.left, X-1, Y-1);
		traverse(root.right, X+1, Y-1);
	}
}