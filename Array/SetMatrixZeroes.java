/*
Question Link: https://leetcode.com/problems/set-matrix-zeroes/
Approach: Set the start of row and column to zero, if the element is zero. Then traverse the array and set the whole row and column to zero.
First row and first column is to be handled separately.
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean startIsZero = matrix[0][0]==0;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                    if(i==0)
                        firstRowZero = true;
                    if(j==0)
                        firstColZero = true;
                }
            }
        }
        for(int i=matrix.length-1; i>0; i--){
            if(matrix[i][0]==0){
                for(int j=1; j<matrix[i].length; j++)
                    matrix[i][j]=0;
            }
        }
        for(int j=matrix[0].length-1; j>0; j--){
            if(matrix[0][j]==0){
                for(int i=1; i<matrix.length; i++)
                    matrix[i][j]=0;
            }
        }
        if(startIsZero || firstRowZero || firstColZero){
            if(startIsZero||firstColZero){
                for(int i=0; i<matrix.length; i++)
                    matrix[i][0]=0;
            }
            if(startIsZero||firstRowZero){
                for(int j=0; j<matrix[0].length; j++)
                    matrix[0][j]=0;
            }
        }
    }
}