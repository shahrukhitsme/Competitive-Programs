/*
Question Link: https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/1/?track=md-tree&batchId=144#
Approach: Add root.data, then add right child to stack, then left child to stack. Then set root to null and in the next iteration root = stack.pop
*/
class Tree
{
    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while(!st.isEmpty() || root!=null){
            if(root==null)
                root = st.pop();
            res.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
            root = null;
        }
        return res;
    }
}