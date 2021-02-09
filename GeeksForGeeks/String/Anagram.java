/*
Question Link: https://practice.geeksforgeeks.org/problems/anagram-1587115620/1/?track=md-string&batchId=144#
Approach: Traverse through the string and increase the counter for each charater of first string in character array and decrease for the second string. If all values in the array is 0, return true, else return false.
*/
class Anagram{    
    /*  Function to check if two strings are anagram
    *   a, b: input string
    */
    public static boolean isAnagram(String a,String b)
    {
        if(a.length()!=b.length())
            return false;
        int[] count = new int[256];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}