/*
Question Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Approach: Recursion
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<List<String>> letters = new ArrayList<>();
        List<String> let = new ArrayList<>();
        let.add("a");
        let.add("b");
        let.add("c");
        letters.add(let);
        let = new ArrayList<>();
        let.add("d");
        let.add("e");
        let.add("f");
        letters.add(let);
        let = new ArrayList<>();
        let.add("g");
        let.add("h");
        let.add("i");
        letters.add(let);
        let = new ArrayList<>();
        let.add("j");
        let.add("k");
        let.add("l");
        letters.add(let);
        let = new ArrayList<>();
        let.add("m");
        let.add("n");
        let.add("o");
        letters.add(let);
        let = new ArrayList<>();
        let.add("p");
        let.add("q");
        let.add("r");
        let.add("s");
        letters.add(let);
        let = new ArrayList<>();
        let.add("t");
        let.add("u");
        let.add("v");
        letters.add(let);
        let = new ArrayList<>();
        let.add("w");
        let.add("x");
        let.add("y");
        let.add("z");
        letters.add(let);
        StringBuilder s = new StringBuilder();
        possibleWords(res, letters, digits, 0, s);
        return res;
    }
    
    public void possibleWords(List<String> res, List<List<String>> letters, String digits, int index, StringBuilder s){
        if(index==digits.length()){
            if(!s.toString().equals(""))
                res.add(s.toString());
            return;
        }
        int digit = digits.charAt(index)-'0';
        List<String> currChars = letters.get(digit-2);
        for(int i=0; i<currChars.size(); i++){
            String currChar = currChars.get(i);
            StringBuilder s1 = new StringBuilder();
            s1.append(s);
            s.append(currChar);
            possibleWords(res, letters, digits, index+1, s);
            s=s1;
        }
    }
}