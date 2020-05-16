/*
Question Link: https://leetcode.com/problems/plus-one/submissions/
Approach: The length will increase only in case all digits are 9. Traverse from back, and if any number is less than 9, add 1 and return else,
set that value to 0 ,and traverse keep traversing. If all are 9. Create a new array of size + 1, and set the leftmost index to 1, rest remain 0.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}