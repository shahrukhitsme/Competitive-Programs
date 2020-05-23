/*
Question Link: https://leetcode.com/problems/palindrome-partitioning/
Approach: Create a list of list of integers, and for each index, store the next index, between which(both inclusive) the string will be a pallindrome.
Next use recursive approach to find all possible paths to reach the end of the string, while add pallindrominc substrings to a list, and if the end is reached, add that list to the result.
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append(s);
        int len = str.length();
        List<List<Integer>> entries = new ArrayList<>();
        entries.add(new ArrayList<Integer>());
        entries.get(0).add(0);
        for(int i=1; i<len; i++){
            entries.add(new ArrayList<Integer>());
            int j=0;
            while(i-j>=0 && i+j<len){
                if(str.charAt(i-j)!=str.charAt(i+j))
                    break;
                entries.get(i-j).add(i+j);
                j++;
            }
            j=0;
            while(i-j-1>=0 && i+j<len){
                if(str.charAt(i-j-1)!=str.charAt(i+j))
                    break;
                entries.get(i-j-1).add(i+j);
                j++;
            }
        }
        addPallindromes(entries, res, new ArrayList<String>(), 0, str);
        return res;
    }
    
    public void addPallindromes(List<List<Integer>> entries, List<List<String>> res, List<String> pallindrome, int index, StringBuilder str){
        if(index==str.length()){
            res.add(pallindrome);
            return;
        }
        int target;
        for(int i=0; i<entries.get(index).size(); i++){
            target = entries.get(index).get(i);
            List<String> pal = new ArrayList<>(pallindrome);
            pal.add(str.substring(index, target+1));
            addPallindromes(entries, res, pal, target+1, str);
        }
    }
}