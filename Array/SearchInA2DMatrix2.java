/*
Question Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
Approach: Used Recursion. From top left, check on diagonal elements, till the element is lesser than target, then passed the remaining of array on top and right,
and the one on left and below to the same function.
A better approach was found in which it started form top right, and if target is found then return true else if it is lesser, than col--, else row++
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length == 0)
            return false;
        return find(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    
    public boolean find(int[][] matrix, int target, int sI, int sJ, int eI, int eJ){
        if(sI>=matrix.length || sJ>=matrix[0].length || eI>=matrix.length || eJ>=matrix[0].length || eI<sI || eJ<sJ)
            return false;
        int i;
        for(i=sI; i<=eI && sJ+i-sI<=eJ; i++){
            if(matrix[i][sJ+i-sI]==target)
                return true;
            if(matrix[i][sJ+i-sI]>target)
                break;
        }
        return find(matrix, target, sI, sJ+i-sI, i-1, eJ) | find(matrix, target, i, sJ, eI, sJ+i-sI-1);
    }
}

//Better Approach
/*
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
*/