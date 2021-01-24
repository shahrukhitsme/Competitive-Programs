/*
Question Link: https://leetcode.com/problems/partition-labels/
Approach: Stored count of all charaters in the string.
Then started traversing by reduscing the count, if count is not zero, add it to a set, else if it is zero remove it from the set.
Wherever the size of set will become zero, we would have a partition.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0; i< S.length(); i++){
            count[S.charAt(i)-97]++;
        }
        HashSet<Integer> underOperation = new HashSet<>();
        int len=0;
        for(int i=0; i< S.length(); i++){
            int charIndex = S.charAt(i)-97;
            count[charIndex]--;
            if(count[charIndex]>0 && !underOperation.contains(charIndex))
                underOperation.add(charIndex);
            else if(count[charIndex]==0 && underOperation.contains(charIndex))
                underOperation.remove(charIndex);
            if(underOperation.size()==0){
                res.add(len+1);
                len=0;
            }
            else
                len++;
        }
        return res;
    }
}