/*
Question Link: https://leetcode.com/problems/linked-list-cycle/
Approach: Take 2 pointers, and move one with a speed of 1, and the other with a speed of 2.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1,p2;
        p1 = p2 = head;
        while(p2!=null){
            p1 = p1.next;
            p2 = p2.next;
            if(p2!=null)
                p2 = p2.next;
            else return false;
            if(p1==p2)
                return true;
        }
        return false;
    }
}