/*
Question Link: https://leetcode.com/problems/counting-bits/submissions/
Approach: First approach is simply using the solution of the number which is it's half. Ex: for 9, which is 1001, and it's half is 4 which is 100. So, just an extra bit is added in 9, which is found by 9%2, and the remaining bits are same.
Approach 2: Found a pattern and coded on top of that. Pattern:
Number of 1's given sequentially: 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4 1 2 2 3  2 3 3 4  2 3 3 4  3 4 4 5 1 2 2 3  2 3 3 4  2 3 3 4  3 4 4 5  2 3 3 4  3 4 4 5  3 4 4 5  4 5 5 6
This can be viewed as:
0
1
1 2
1 2 2 3
1 2 2 3  2 3 3 4
1 2 2 3  2 3 3 4  2 3 3 4  3 4 4 5
1 2 2 3  2 3 3 4  2 3 3 4  3 4 4 5  2 3 3 4  3 4 4 5  3 4 4 5  4 5 5 6
1 2 2 3  2 3 3 4  2 3 3 4  3 4 4 5  2 3 3 4  3 4 4 5  3 4 4 5  4 5 5 6  2 3 3 4  3 4 4 5  3 4 4 5  4 5 5 6  3 4 4 5  4 5 5 6  4 5 5 6  5 6 6 7

*/

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0)
            return res;
        res[1] = 1;
        int i=2;
        while(i<=num){
            res[i] = res[i>>1] + (i&1);  //basically res[i] = res[i/2] + i%2; Coz dividing by 2 just shift the bits to the right.
            i++;
        }
        return res;
    }
}

/*
Solution 2:
public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0)
            return res;
        res[1] = 1;
        int i=2;
		int currLevel = 2;
        int posInCurrLevel = 0;
        int numsToCopy = currLevel/2;
        int currLimit = numsToCopy;
        while(i<=num){
            if(numsToCopy == 0)
                res[i] = res[i-1] + 1;
            res[i] = res[i - numsToCopy];
            i++;
            posInCurrLevel++;
            if(posInCurrLevel == currLimit){
                numsToCopy /= 2;
                currLimit += numsToCopy;
            }
            if(posInCurrLevel == currLevel){
                posInCurrLevel = 0;
                currLevel = currLevel*2;
                numsToCopy = currLevel/2;
			    currLimit = numsToCopy;
            }
			return res;
		}
	}
*/