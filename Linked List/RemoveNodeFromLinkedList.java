/*
Question Link:https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
Approach: Just pull the values and remove the last node
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while(p.next.next!=null){
            p.val = p.next.val;
            p = p.next;
        }
        p.val = p.next.val;
        p.next = null;
    }
}