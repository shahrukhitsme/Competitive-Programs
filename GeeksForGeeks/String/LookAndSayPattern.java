/*
Question Link: https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1/?track=md-string&batchId=144
Approach: Brute force
*/
class Solution{
    static String lookandsay(int n)
    {
        String s = "1";
        for(int i=2; i<=n; i++){
            int j=1;
            int len = s.length();
            char lastChar = s.charAt(0);
            int lastCount = 1;
            StringBuilder sb = new StringBuilder();
            while(j<len){
                char curr = s.charAt(j);
                if(curr == lastChar)
                    lastCount++;
                else{
                    sb.append(lastCount).append(lastChar);
                    lastChar = curr;
                    lastCount = 1;
                }
                j++;
            }
            sb.append(lastCount).append(lastChar);
            s = sb.toString();
        }
        return s;
    }
}