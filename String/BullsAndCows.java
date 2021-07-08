/*
Question Link: https://leetcode.com/problems/bulls-and-cows/submissions/
Approach: Just traversed the strings linearly, and stored the digit occurences of both. Then again traversed to count the number of correct digit at correct positions, i.e., the bulls. Then compared the occurences of both and found out total number of common digits, and subtracted the bulls from them which gave the number of correct digits at wrong places, i.e., the cows.
*/
class Solution {
    public String getHint(String secret, String guess) {
        int[] occurenceSecret = new int[10];
        for(int i=0; i<secret.length(); i++){
            int curr = secret.charAt(i)-'0';
            occurenceSecret[curr] = occurenceSecret[curr]+1;
        }
        int[] occurenceGuess = new int[10];
        for(int i=0; i<guess.length(); i++){
            int curr = guess.charAt(i)-'0';
            occurenceGuess[curr] = occurenceGuess[curr]+1;
        }
        
        int bulls = 0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i)==guess.charAt(i))
                bulls++;
        }
        
        int cows = 0;
        for(int i=0; i<10; i++){
            cows+=Math.min(occurenceSecret[i], occurenceGuess[i]);
        }
        cows-=bulls;
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}