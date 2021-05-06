/*
Question link: https://practice.geeksforgeeks.org/problems/maximum-xor-of-two-numbers-in-an-array/1
Approach: Used Trie. A trie to store binary numbers. Each node can have two children only. left child mean current bit is 0, and right child means current bit is 1. Root starts with 
the most significant bit. So, we insert all elements in the Trie like that. And then for each element, we try to find the max XOR. So the idea is that, starting from the most significant bit,
we start to towards the child which has the opposite bit. Then only XOR for that bit will be 1, and our result will maximize. Suppose current bit is 1, then we will move left, as left
will go towards the numbers which have 0 at that bit, and vice-versa, thus the resultant number will have 1 in that bit position. If the opposite bit path is not there, we have to 
move to the same bit path only then, and in that case, the resultant number will have 0 at that bit.
*/
class Solution
{
    public static int max_xor(int arr[], int n)
    {
        Node root = new Node();
        insert(root, arr[0], 30);
        int val=0;
        for(int i=0; i<arr.length; i++){
            val = Math.max(val, query(root, arr[i], 30));
            insert(root, arr[i], 30);
        }
        return val;
    }
    
    public static void insert(Node root, int value, int level){
        if(level==-1)
            return;
            
        if((value&(1<<level))>0){
            if(root.right==null)
                root.right = new Node();
            insert(root.right, value, level-1);
        }else{
            if(root.left==null)
                root.left = new Node();
            insert(root.left, value, level-1);
        }
    }
    
    public static int query(Node root, int value, int level){
        if(level==-1)
            return 0;
            
        if((value&(1<<level))>0){
            //move left
            if(root.left==null)
                return query(root.right, value, level-1);
            return query(root.left, value, level-1)|(1<<level);
        }else{
            //move right
            if(root.right==null)
                return query(root.left, value, level-1);
            return query(root.right, value, level-1)|(1<<level);
        }
    }
}

class Node{
    Node left;
    Node right;
    int bit;
}