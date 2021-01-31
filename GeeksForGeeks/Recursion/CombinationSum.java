/*
Question Link: https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1/?track=md-recursion&batchId=144
Approach: Sorted the array and DFS, and used hashset to maintain uniqueness.
*/
class Solution
{
    static HashSet<List<Integer>> set;
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(A);
        set = new HashSet<>();
        getCount(0, A, B, 0, res, null);
        return res;
    }
    
    static void getCount(int index, int A[], int B, int sum, List<List<Integer>> res, List<Integer> com){
        if(com==null)
            com = new ArrayList<Integer>();
        if(sum==B){
            if(!set.contains(com)){
                set.add(com);
                res.add(com);
            }
            return;
        }
        if(index>=A.length || sum>B)
            return;
        List<Integer> com1 = new ArrayList<Integer>(com);
        List<Integer> com2 = new ArrayList<Integer>(com);
        com2.add(A[index]);
        getCount(index+1, A, B, sum+A[index], res, com2);
        getCount(index+1, A, B, sum, res, com1);
    }
}