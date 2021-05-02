/*
Question Link: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Keep copying next elements data to current element, and detach last element.
*/
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        Node temp = del;
        while(temp.next.next!=null){
            temp.data = temp.next.data;
            temp=temp.next;
        }
        temp.data = temp.next.data;
        temp.next=null;
    }
}