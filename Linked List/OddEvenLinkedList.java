/*
Question Link: https://leetcode.com/problems/odd-even-linked-list/
Approach: Keep 4 pointers pointing to evenHead, oddHead, evenEnd, oddEnd, and a pointer which traverses the linked list and attaches each node to respective even or odd list. At last attched oddHead to evenEnd, and null to oddEnd, and returns evenHead.
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode evenHead = head;
        ListNode oddHead = head.next;
        ListNode evenPtr = evenHead, oddPtr=oddHead;
        if(oddHead==null)
            return evenHead;
        ListNode walker = oddHead.next;
        while(walker!=null){
            evenPtr.next = walker;
            evenPtr = evenPtr.next;
            walker = walker.next;
            if(walker!=null){
                oddPtr.next = walker;
                oddPtr = oddPtr.next;
                walker = walker.next;
            }
        }
        evenPtr.next = oddHead;
        oddPtr.next = null;
        return evenHead;
    }
}