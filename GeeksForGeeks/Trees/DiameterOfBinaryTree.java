/*
Question Link: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1/?track=md-tree&batchId=144#
Approach: Used recursion, to find depth of left subtree and right subtree. For each node, after getting those, checking if it makes the maximum possible diameter yet in a global variable.
*/
class Tree {
    int max = 0;
    
    int diameter(Node root) {
        int res = process(root)+1;
        return Math.max(res, max);
    }
    
    int process(Node root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        int leftHeight = process(root.left)+1;
        int rightHeight = process(root.right)+1;
        if(leftHeight+rightHeight+1>max)
            max = leftHeight+rightHeight+1;
        if(leftHeight>rightHeight)
            return leftHeight;
        return rightHeight;
    }
}