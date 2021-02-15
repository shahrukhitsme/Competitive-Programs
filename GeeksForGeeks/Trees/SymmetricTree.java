/*
Question Link: https://practice.geeksforgeeks.org/problems/symmetric-tree/0/?track=md-tree&batchId=144#
Approach: Recursion
*/
class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if(root==null) return true;
        return check(root.left, root.right);
    }
    
    public static boolean check(Node n1, Node n2){
        if(n1==null && n2==null)
            return true;
        if((n1==null && n2!=null) || (n1!=null && n2==null))
            return false;
        return (n1.data==n2.data && check(n1.left, n2.right) && check(n1.right, n2.left));
    }
}