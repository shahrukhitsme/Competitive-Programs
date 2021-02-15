/*
Question Link: https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1/?track=md-tree&batchId=144#
Approach: Recursion
*/
class Solution {
    int height(Node node) {
        if(node==null) return 0;
        return Math.max(height(node.left), height(node.right))+1;
    }
}