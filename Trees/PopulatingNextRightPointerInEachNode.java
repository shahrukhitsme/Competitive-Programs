/*
Question Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
Approach: Join root's left with root's right, and root's right with root's next's right
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        if(root.left==null)
            return root;
        if(root.next==null)
            root.right.next=null;
        else
            root.right.next = root.next.left;
        root.left.next = root.right;
        connect(root.right);
        connect(root.left);
        return root;
    }
}