/*
Question Link: https://practice.geeksforgeeks.org/problems/mirror-tree/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: swap left and right child, and call the same method recursively on both children.
*/
class Solution
{
    //Function to convert a binary tree into its mirror tree.
    void mirror(Node node)
    {
        if(node==null) return;
        Node temp = node.left;
        node.left=node.right;
        node.right=temp;
        mirror(node.left);
        mirror(node.right);
    }
}