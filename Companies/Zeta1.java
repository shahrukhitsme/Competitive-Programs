/*
Divide a string into maximum number of substrings that each substring only has those characters which are not there in any other substring. Return the lengths of those substrings.
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
*/
public List<Integer> findPartitions(String s){
    List<Integer> res = new ArrayList<>();
    int[] counts = new int[26];
    int activeElements = 0;
    boolean[] existInCurrentStr = new boolean[26];
    for(int i = 0; i < s.length(); i++)
        counts[s.charAt(i)-'a']++;
    int lastIndex = 0;
    for(int i=0; i<s.length(); i++){
        char currChar = s.charAt(i);

        if(!existInCurrentStr[currChar]){
            existInCurrentStr[currChar] = true;
            activeElements++;
        }

        counts[currChar-'a']--;
        
        if(counts[currChar-'a'] == 0){
            activeElements--;
            existInCurrentStr[currChar] = false;
            if(activeElements==0)
                res.add(i-lastIndex+1);
                lastIndex=i+1;
        }
    }
    return res;
}