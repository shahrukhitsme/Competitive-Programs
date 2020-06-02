/*
Question Link: https://leetcode.com/problems/sort-list/
Approach: Merge Sort
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
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        int l = 0;
        ListNode trav = head;
        while(trav!=null){
            l++;
            trav = trav.next;
        }
        return sort(head, l);
    }
    
    public ListNode sort(ListNode start, int length){
        if(length==1){
            if(start!=null)
                start.next = null;
            return start;
        }
        int m = length/2;
        ListNode mid = start;
        int t = 1;
        while(t<m){
            mid = mid.next;
            t++;
        }
        ListNode start2 = mid.next;
        ListNode h1 = sort(start, m);
        ListNode h2 = sort(start2, length-m);
        return merge(h1, h2);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode trav1 = head1;
        ListNode trav2 = head2;
        ListNode h;
        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;
        if(head1.val < head2.val){
            h = head1;
            trav1 = trav1.next;
        }
        else{
            h = head2;
            trav2 = trav2.next;
        }
        ListNode trav = h;
        while(trav1!=null || trav2!=null){
            if(trav1==null){
                trav.next = trav2;
                trav = trav.next;
                trav2 = trav2.next;
            }
            else if(trav2==null){
                trav.next = trav1;
                trav = trav.next;
                trav1 = trav1.next;
            }
            else{
                if(trav1.val < trav2.val){
                    trav.next = trav1;
                    trav = trav.next;
                    trav1 = trav1.next;
                }
                else{
                    trav.next = trav2;
                    trav = trav.next;
                    trav2 = trav2.next;
                }
            }
        }
        trav.next = null;
        return h;
    }
}