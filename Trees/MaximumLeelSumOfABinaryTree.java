/*
Question Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
Approach: Used BFS. Used a queue for that. Then kept track of levels and for each level calculated the sum of nodes at that level and compared with max.
*/
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max = root.val-1;
        int maxLevel = 0;
        int level = 0;
        if(root!=null)
            q.add(root);
        int size = 1;
        int temp = 0;
        while(size>0){
            level++;
            while(size-->0){
                TreeNode curr = q.remove();
                temp+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(temp>max){
                max = temp;
                maxLevel = level;
            }
            temp = 0;
            size = q.size();
        }
        return maxLevel;
    }
}