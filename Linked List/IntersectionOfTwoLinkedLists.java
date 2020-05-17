/*
Question Link: https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
Approach1: Keep traversing both the lists, and when they become null, set them to head of the other linked list, and keep traversing.
Approach2: Find the lengths of both the linked lists, and calculated the difference of their lengths before common node.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Approach1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode p1 = headA, p2 = headB;
        while(p1!=p2){
            p1 = p1==null?headB:p1.next;
            p2 = p2==null?headA:p2.next;
        }
        return p1;
    }
}

//Approach2
/* 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int l1=0, l2=0;
        ListNode p1 = headA, p2=headB;
        while(p1!=null){
            p1 = p1.next;
            l1++;
        }
         while(p2!=null){
            p2 = p2.next;
            l2++;
        }
        p1 = headA;
        p2 = headB;
        while(l1>0 && l2>0 && l1!=l2){
            p1 = l1>l2?p1.next:p1;
            l1 = l1>l2?l1-1:l1;
            p2 = l1<l2?p2.next:p2;
            l2 = l1<l2?l2-1:l2;
        }
        while(p1!=null){
            if(p1==p2)
                return p1;
            p1 = p1.next;
            p2=p2.next;
        }
        return null;
    }
} */