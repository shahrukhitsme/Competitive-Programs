/*
Question Link: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/0/?track=md-tree&batchId=144#
Approach: Recursrion. Make a simple level order traversal and store in a 2 dimensional array. Then based on even and odd index, add items to the final list in normal order or reverse order.
*/
class Spiral
{
      ArrayList<Integer> findSpiral(Node root) 
      {
           ArrayList<ArrayList<Integer>> res = new ArrayList<>();
           ArrayList<Integer> ret = new ArrayList<>();
           add(root, res, 0);
           for(int i=0; i<res.size(); i++){
               if(i%2!=0){
                   for(int j=0; j<res.get(i).size(); j++)
                       ret.add(res.get(i).get(j));
               }
                else{
                   for(int j=res.get(i).size()-1; j>=0; j--)
                       ret.add(res.get(i).get(j));
                }
           }
           return ret;
       }
      
      void add(Node root, ArrayList<ArrayList<Integer>> res, int level){
          if(root==null)
            return;
            if(res.size()<level+1)
                res.add(new ArrayList<Integer>());
            res.get(level).add(root.data);
            add(root.left, res, level+1);
            add(root.right, res, level+1);
      }
}