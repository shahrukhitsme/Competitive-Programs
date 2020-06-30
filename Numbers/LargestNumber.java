/*
Question Link: https://leetcode.com/problems/largest-number/
Approach: Create a comparator and sort the array
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++)
            str[i] = Integer.toString(nums[i]);
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String s1=a+b;
                String s2=b+a;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(str, comp);
        if(str[0].charAt(0) == '0')
			return "0";
        StringBuilder sb = new StringBuilder();
		for(String s: str)
	        sb.append(s);
		
		return sb.toString();
    }
}