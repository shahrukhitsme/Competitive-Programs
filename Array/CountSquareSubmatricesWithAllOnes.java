/*
Question Link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
Approach: Start from top left, and keep updating the array. The number at a particular index shall be equal to the number of valid squared with that cell as its bottom-right cell. So, row i=0, and column j=0 will remain unchanges (0 or 1, whatever their value is). From the next cell, if value is 1, at least 1 valid square is forming which is of size 1. And add to it minimum of the 3 cells (left, top, diagonally left-top). Suppose all have 4, which means that for current cell, I can have a valid square of length 5, which means 4 more square of lengths 2,3,4 and 5. So add that to 1 and update that cell. Then add the cell's value to the result.
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]>0 && i>0 && j>0){
                    matrix[i][j] = Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]))+1;
                }
                res+=matrix[i][j];
            }
        }
        return res;
    }
}