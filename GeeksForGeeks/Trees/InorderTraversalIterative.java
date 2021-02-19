/*
Question Link: https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/?track=md-tree&batchId=144#
Approach: Traverse to the leftmost child and keep adding in stack. Then keep popping from stack and adding in solution until poppend node does not have a right child. If popped node has a right child, make it root for next iteration.
*/
class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while(temp!=null || st.size()!=0){
            goToLeft(temp, st);
            Node temp2 = st.pop();
            res.add(temp2.data);
            while(temp2.right==null && st.size()>0){
                temp2 = st.pop();
                res.add(temp2.data);
            }
            if(temp2!=null)
                temp=temp2.right;
        }
        return res;
    }
    
    void goToLeft(Node root, Stack<Node> st){
        Node temp = root;
        while(temp!=null){
            st.push(temp);
            temp = temp.left;
        }
    }
}