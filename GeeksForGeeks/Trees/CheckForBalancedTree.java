/*
Question Link: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1/?track=md-tree&batchId=144#
Approach: Use recursion. Get height of left subtree and right subtree. Keep checking for each node if it is balanced, and if not, keep returning -1
*/
class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
        int res = process(root);
        if(res==-1)
            return false;
        return true;
    }
    
    int process(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int leftH = process(root.left);
        int rightH = process(root.right);
        if(leftH==-1||rightH==-1)
            return -1;
        if(Math.abs(leftH-rightH)>1)
            return -1;
        return Math.max(leftH, rightH)+1;
    }
}