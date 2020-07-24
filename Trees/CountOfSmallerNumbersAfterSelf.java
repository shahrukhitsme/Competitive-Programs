/*
Question Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self
Approach: Traverse from right to left, and create a BST in that order. So, at each addition of node, count how many numbers you passed were smaller, and also add the leftChildren of those nodes which were greater.
So, we have to keep track of leftChildren as well. Also keep track of duplicate entries and add them to the sum accordingly.
*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for(int i=nums.length-1; i>=0; i--)
            root = count(nums, i, res, root, 0);
        return Arrays.asList(res);
    }
    
    public Node count(int[] nums, int i, Integer[] res, Node root, int temp){
        if(root==null){
            root = new Node();
            root.dup = 0;
            root.val = nums[i];
            root.leftChildren = 0;
            res[i] = temp;
        }
        else if(nums[i]==root.val){
            root.dup++;
            res[i] = temp + root.leftChildren;
        }
        else if(nums[i]>root.val){
            root.right = count(nums, i, res, root.right, temp+root.leftChildren+root.dup+1);
        }
        else{
            root.leftChildren++;
            root.left = count(nums, i, res, root.left, temp);
        }
        return root;
    }
}

class Node{
    Node left;
    Node right;
    int val;
    int leftChildren;
    int dup;
    Node(){
        left = null;
        right = null;
        leftChildren = 0;
        dup = 0;
        val=0;
    }
}