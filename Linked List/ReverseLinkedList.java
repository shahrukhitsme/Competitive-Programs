/*
Question Link: https://leetcode.com/problems/reverse-linked-list/submissions/
Approach: Keep a node pointing at head. Move another node forward and attach it to the head, and update the pointer pointing to the head.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	//Recursive approach
    public ListNode reverseList(ListNode head) {
        return rev(head, null);
    }
    
    public ListNode rev(ListNode head, ListNode newHead){
        if(head==null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return rev(next, head);
    }
    
	//Iterative approach
    /*
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode head2 = new ListNode(-1, head);
        ListNode p = head.next;
        head.next = null;
        ListNode q;
        while(p!=null){
            q = p.next;
            p.next = head2.next;
            head2.next = p;
            p = q;
        }
        return head2.next;
    }*/
}