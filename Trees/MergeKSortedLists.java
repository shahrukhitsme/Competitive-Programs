/*
Question Link: https://leetcode.com/problems/merge-k-sorted-lists/
Approach: Since all the lists are already sorted, the respective heads of the lists would already be in sorted order. So, we just need to keep track of the heads, and need to know that for now, which is the largest head, instead of knowing the whole sorted order
of all heads at that point of time. And then we need to remove the largest head, and add the next head of that list to that list of heads. For finding the maximum head at a point of time, we use PriorityQueue or to say MaxHeap.
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
             }
            });
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        ListNode head = null;
        ListNode temp = null;
        boolean firstTime = true;
        while(!pq.isEmpty()){
            if(firstTime){
                head = new ListNode();
                temp = head;
                firstTime = false;
            }
            else{
                temp.next = new ListNode();
                temp = temp.next;
            }
            ListNode nextNode = pq.poll();
            temp.val = nextNode.val;
            if(nextNode.next!=null)
                pq.add(nextNode.next);
        }
        return head;
    }
}