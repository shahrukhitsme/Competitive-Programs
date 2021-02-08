/*
Question Link: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/0/?track=md-string&batchId=144
Approach: Used sliding window technique, and a hashmap to store the count of characters in the current window, also a variable to store the current unique count, based on the
counts of hashmap which is updated for a particular character in each iteration. Whenever the count is equal to k, update the max if it is greater then current max.
*/
class Solution
{
    public int longestkSubstr(String s, int k)
    {
        HashMap<Character, Integer> mp = new HashMap<>();
        int max = 0;
        int i=0, j=0;
        int unique = 0;
        for(; j<s.length(); j++){
            char curr = s.charAt(j);
            if((mp.containsKey(curr) && mp.get(curr)==0) || !mp.containsKey(curr)){
                mp.put(curr, 1);
                unique++;
                if(unique>k){
                    while(i<j){
                        char currI = s.charAt(i);
                        mp.put(currI, mp.get(currI)-1);
                        if(mp.get(currI)==0){
                            unique--;
                        }
                        i++;
                        if(unique==k)
                            break;
                    }
                }
            }
            else{
                mp.put(curr, mp.get(curr)+1);
            }
            
            if(unique==k){
                if(j-i+1>max){
                    max=j-i+1;
                    //System.out.println(s.substring(i, j+1)+" "+i+" "+j);
                }
            }
        }
        return max==0?-1:max;
    }
}