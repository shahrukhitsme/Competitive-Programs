/*
Question Link: https://practice.geeksforgeeks.org/problems/check-for-bst/1
Approach: Do an inorder traversal and check if array is sorted.
*/

/*
Structure of Node:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

public class Solution
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
        {
            List<Integer> ls = new ArrayList<Integer>();
            inOrder(ls, root);
            for(int i=0; i<ls.size()-1; i++){
                if(ls.get(i)>=ls.get(i+1))
                    return false;
            }
            return true;
        }
        
    void inOrder(List<Integer> ls, Node root){
        if(root==null)
            return;
        inOrder(ls, root.left);
        ls.add(root.data);
        inOrder(ls, root.right);
    }

}