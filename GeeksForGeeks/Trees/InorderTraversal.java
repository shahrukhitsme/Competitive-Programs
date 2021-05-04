/*
Question Link: https://practice.geeksforgeeks.org/problems/inorder-traversal/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: inorder(root.left);
        res.add(root.data);
        inorder(root.right);
*/
class Solution
{
    ArrayList<Integer> res = null;
    //Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root)
    {
        res = new ArrayList<Integer>();
        inorder(root);
        return res;
    }
    
    void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        res.add(root.data);
        inorder(root.right);
    }
}