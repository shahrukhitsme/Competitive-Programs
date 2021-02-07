/*
Question Link: https://practice.geeksforgeeks.org/problems/implement-strstr/0/?track=md-string&batchId=144
Approach: O(N) traversal and finding target string using substring
*/
{
    int strstr(String str, String target)
    {
        int len = target.length();
       for(int i=0; i<=str.length()-len; i++){
           if(str.substring(i, i+len).equals(target))
            return i;
       }
       return -1;
    }
}