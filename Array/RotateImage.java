/*
Question Link: https://leetcode.com/problems/rotate-image/
Approach: For every index, the transormation would be:
i1, j1 = 0,0
i2,j2 = j1, n-1-i1 = 0, 2
i3,j3 = n-1-i1, n-1-j1 = 2, 2
i4,j4 = n-1-j1, i1 = 2, 0
i5, j5 = i1, j1
*/
class Solution {
    public void rotate(int[][] matrix) {
		int dimen = matrix.length;
		int indexI,indexJ, temp1, temp2;
		for(int i=0; i< dimen; i+=2){
			for(int j=i/2; j< dimen-(i/2)-1; j++){
				indexI=i/2;
				indexJ=j;
				temp1 = matrix[indexI][indexJ];
				for(int k=1; k<=4; k++){
					temp2 = indexI;
					indexI = indexJ;
					indexJ = dimen - 1 - temp2;
					temp2 = matrix[indexI][indexJ];
					matrix[indexI][indexJ] = temp1;
					temp1 = temp2;
				}
			}
		}
    }
}