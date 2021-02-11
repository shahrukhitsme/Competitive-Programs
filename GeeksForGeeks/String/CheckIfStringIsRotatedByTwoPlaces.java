/*
Question Link: https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1/?track=md-string&batchId=144#
Approach: Just compute substring accordingly and compare.
*/
class Rotation{
    
    /*  Function to check if two strings are rotated
    *   s1, s2: input strings
    */
    public static boolean isRotated(String s1, String s2){
        if((s1.length()==1||s1.length()==2))
            return s1.equals(s2);
        return ((s1.substring(s1.length()-2,s1.length())+s1.substring(0,s1.length()-2)).equals(s2)) || ((s2.substring(s2.length()-2,s2.length())+s2.substring(0,s2.length()-2)).equals(s1));
    }
    
}