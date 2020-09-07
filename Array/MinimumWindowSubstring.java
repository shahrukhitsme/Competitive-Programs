/*
Question Link: https://leetcode.com/problems/minimum-window-substring/
Approach: Used a sliding window, and kept track of the count of the required letters inside that window. Whenever the count is insufficient, increment end pointer of the window.
Else if the count is sufficient, update the result string, and increment the starting pointer of the window. Keep doing this until the end pointer reaches the end.
*/
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for(int i=0; i<t.length(); i++)
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i),0)+1);
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int i=0, j=0, len=t.length();
        int min = s.length()+1;
        String res = "";
        while(j<=s.length()){
            //System.out.println(i+" "+j+" "+compareMaps(windowCount, counts));
            if(compareMaps(windowCount, counts)){
                if(j-i<min){
                    min = j-i+1;
                    res = s.substring(i, j);
                }
                char curr = s.charAt(i);
                if(windowCount.getOrDefault(curr, 0)>0)
                    windowCount.put(curr, windowCount.get(curr)-1);
                i++;
            }
            else{
                if(j==s.length())
                    break;
                char curr = s.charAt(j);
                if(counts.getOrDefault(curr, 0)>0)
                    windowCount.put(curr, windowCount.getOrDefault(curr, 0)+1);
                j++;
            }
        }
        return res;
    }
    
    public boolean compareMaps(HashMap<Character, Integer> a, HashMap<Character, Integer> b){
        for(char key: b.keySet()){
            if(a.getOrDefault(key, 0)<b.get(key))
                return false;
        }
        return true;
    }
}