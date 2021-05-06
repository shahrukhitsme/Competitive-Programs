/*
Question Link: https://practice.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: For first list, store count of each x-element in Hashmap, find whether it is present in the second list or not. If yes, add the count to the result.
*/
class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < head1.size(); i++){
            int data = x-head1.get(i);
            mp.put(data, mp.getOrDefault(data, 0)+1);
        }
        int res=0;
        for (int i = 0; i < head2.size(); i++)
            res+=mp.getOrDefault(head2.get(i), 0);
        return res;
    }
}