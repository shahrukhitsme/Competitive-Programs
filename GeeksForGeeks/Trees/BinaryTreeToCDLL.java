/*
Question Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon#
Approach: Inorder traversal
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        Node head = new Node(-1);
        Node last = inorder(head, root);
        last.right = head;
        head.left = last;
        return head;
    }
    
    Node inorder(Node head, Node root){
        if(root==null)
            return head;
        head = inorder(head, root.left);
        if(head.data==-1)
            head.data = root.data;
        else{
            Node newNode = new Node(root.data);
            head.right = newNode;
            newNode.left = head;
            head = newNode;
        }
        head = inorder(head, root.right);
        return head;
    }
}