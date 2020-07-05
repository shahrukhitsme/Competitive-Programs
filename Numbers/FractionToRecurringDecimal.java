/*
Question Link: https://leetcode.com/problems/fraction-to-recurring-decimal/
Approach: Did normal division
*/
class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
		long numerator = Long.valueOf(numerator1);
		long denominator = Long.valueOf(denominator1);
        boolean isNegative = false;
        if(numerator<0){
            isNegative = !isNegative;
            numerator*=-1;
        }
        if(denominator<0){
            isNegative = !isNegative;
            denominator*=-1;
        }
        HashMap<Integer, Integer> nums = new HashMap<>();
        long whole = numerator/denominator;
        numerator = numerator%denominator;
        long decimal = 0;
        String s="";
        boolean addBracket = false;
        String numer = "";
        int index =0;
		Long nn = numerator;
        while(nn%denominator!=0){
            numer+=Long.toString(numerator);
            if(nums.containsKey(nn.intValue())){
                addBracket = true;
                break;
            }
            nums.put(nn.intValue(), index);
            nn*=10;
            while(nn<denominator){
                nn*=10;
                s+='0';
                index++;
            }
            long fr = nn/denominator;
            nn = nn%denominator;
            s+=fr;
            index++;
        }
        String res = "";
        if(isNegative)
            res="-";
        if(s=="")
            res+= Long.toString(whole);
        else if(addBracket == false)
            res+= Long.toString(whole)+'.'+s;
        else{
            String st = s.substring(0, nums.get(nn.intValue()))+'('+s.substring(nums.get(nn.intValue()), s.length());
            res+=Long.toString(whole)+'.'+st+')';
        }
        if(res.equals("-0"))
            return "0";
        return res;
    }
}