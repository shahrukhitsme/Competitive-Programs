/*
Question Link: https://leetcode.com/problems/copy-list-with-random-pointer/
Approach: Insert new/cloned nodes just after each node in first traversal. In second traversal, set the random pointers accordingly. In third traversal, separated the 2 lists.
*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node trav = head;
        while(trav!=null){
            Node newNode = new Node(trav.val);
            newNode.next = trav.next;
            trav.next = newNode;
            trav = trav.next.next;
        }
        trav = head;
        while(trav!=null){
            trav.next.random = trav.random==null?null:trav.random.next;
            trav = trav.next.next;
        }
        Node head2=null;
        if(head!=null){
        trav = head.next.next;
        head2 = head.next;
        head.next = head.next.next;
        }
        Node trav2 = head2;
        while(trav!=null){
            trav2.next = trav.next;
            trav2 = trav2.next;
            trav.next = trav.next.next;
            trav = trav.next;
        }
        if(trav2!=null)
            trav2.next = null;
        return head2;
    }
}