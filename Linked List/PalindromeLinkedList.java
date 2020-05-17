/*
Question Link: https://leetcode.com/problems/palindrome-linked-list/
Approach: Reverse second half, and compare both halves.
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        int len = 0;
        ListNode p = head;
        while(p!=null){
            p=p.next;
            len++;
        }
        int st = (len+1)/2;
        p = head;
        int count = 0;
        while(count<st){
            p = p.next;
            count++;
        }
        ListNode rev = reverse(p, null);
        p = head;
        for(int i=st; i<len; i++){
            if(rev.val!=p.val)
                return false;
            p=p.next;
            rev = rev.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head, ListNode newHead){
        if(head==null)
            return newHead;
        ListNode n = head.next;
        head.next = newHead;
        return reverse(n, head);
    }
}