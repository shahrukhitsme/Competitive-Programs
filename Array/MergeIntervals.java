/*
Question Link: https://leetcode.com/problems/merge-intervals/
Approach: Used Linked list to keep adding intervals at correct place. Finally, iterate through the list and merge all overlapping intervals.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        ListNode head = null;
        for(int[] range:intervals){
            ListNode newNode = new ListNode();
            ListNode trav = head;
            int s = range[0];
            int e = range[1];
            newNode.start = s;
            newNode.end = e;
            boolean added = false;
            ListNode lastNode = null;
            while(trav!=null){
                if(s>=trav.start && e<=trav.end){
                    added = true;   
                    break;
                }
                else if(e<trav.start){
                    if(lastNode==null){
                        newNode.next = head;
                        head = newNode;
                    }
                    else{
                        ListNode temp = lastNode.next;
                        lastNode.next = newNode;
                        newNode.next = temp;
                    }
                    added = true;
                    break;
                }
                else if(s<trav.start){
                    trav.start = s;
                    if(e>trav.end)
                        trav.end = e;
                    added = true;
                    break;
                }
                else if(s<=trav.end && e>trav.end){
                    trav.end = e;
                    added = true;
                    break;
                }
                lastNode = trav;
                trav = trav.next;
            }
            if(!added){
                if(head==null)
                    head = newNode;
                else{
                    lastNode.next = newNode;
                    newNode.next = null;
                }
            }
        }
        ListNode trav = head;
        int length = 0;
        while(trav!=null && trav.next!=null){
            if(trav.start>=trav.next.start){
                trav.start = trav.next.start;
                if(trav.end<trav.next.end)
                    trav.end = trav.next.end;
                trav.next = trav.next.next;
            }
            else if(trav.end>=trav.next.start){
                if(trav.end<trav.next.end)
                    trav.end = trav.next.end;
                trav.next = trav.next.next;
            }
            else
                trav = trav.next;
        }
        
        trav = head;
        int i=0;
        length = 0;
        while(trav!=null){
            length++;
            trav = trav.next;
        }
        trav=head;
        int[][] res = new int[length][2];
        while(trav!=null){
            res[i][0] = trav.start;
            res[i][1] = trav.end;
            i++;
            trav=trav.next;
        }
        return res;
    }
}

class ListNode{
    int start;
    int end;
    ListNode next;
}