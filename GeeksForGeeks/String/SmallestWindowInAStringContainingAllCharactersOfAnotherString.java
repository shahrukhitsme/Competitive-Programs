/*
Question Link: https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/0/?track=md-string&batchId=144#
Approach: Maintained count of target character count in an array. Traversed first string with start and end pointer and kept updating the count array and in each traversal
checking if the array satisfies the required condition. If yes, min window length is updated.
*/
class solve
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String S, String P){
        int len = S.length();
        int[] alphaCount = new int[26];
        int[] alphaCountCopy = new int[26];
        for(int i=0; i<P.length(); i++){
            alphaCount[P.charAt(i)-'a']++;
            alphaCountCopy[P.charAt(i)-'a']++;
        }
        
        int minLen = len+1;
        int startIndex = 0;
        int resStart = 0;
        int resEnd = 0;
        for(int i=0; i<len; i++){
            int currCharIndex = S.charAt(i)-'a';
            if(alphaCount[currCharIndex]!=0){
                alphaCountCopy[currCharIndex]--;
                if(checkArr(alphaCountCopy)){
                    if(i-startIndex+1<minLen){
                        minLen=i-startIndex+1;
                        resStart = startIndex;
                        resEnd = i+1;
                    }
                    while(startIndex<=i){
                        int startIndexCharIndex = S.charAt(startIndex)-'a';
                        if(alphaCount[startIndexCharIndex]!=0){
                            alphaCountCopy[startIndexCharIndex]++;
                            if(i-startIndex+1<minLen){
                                minLen=i-startIndex+1;
                                resStart = startIndex;
                                resEnd = i+1;
                            }
                            if(alphaCountCopy[startIndexCharIndex]>0){
                                startIndex++;
                                break;
                            }
                        }
                        startIndex++;
                    }
                }
            }
        }
        if(minLen==len+1)
            return "-1";
        return S.substring(resStart, resEnd);
    }
    
    public static boolean checkArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0)
                return false;
        }
        return true;
    }
}