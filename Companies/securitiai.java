//Polyfill of bind in javascript
/*
let matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

function print(matrix) {
}

[1,2,3,6,9,8,7,4,5]
*/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int[][] matrix = {{1, 2, 3, 4},{5, 6, 7 , 8},{9, 10, 11, 12}};
    
		ArrayList<Integer> spiraled = spiral(matrix);
		System.out.println(spiraled);
	}
	
	public static ArrayList<Integer> spiral(int[][] matrix){
    int[][] moves = {
        {0, 1},   //move right
        {1, 0},  //move down
        {0, -1}, //move left
        {-1, 0}  //move up
        };
    int m = matrix.length;
    ArrayList<Integer> res = new ArrayList<>();
    if(m==0)
        return res;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    int i=0, j=0;
    int currMoveIndex = 0;

    while(true){
        res.add(matrix[i][j]);
        visited[i][j] = true;
        if(!isNextBlockValid(visited, i, j, moves, currMoveIndex, m, n)){
            currMoveIndex = (currMoveIndex+1)%4;
            if(!isNextBlockValid(visited, i, j, moves, currMoveIndex, m, n)) //For checking if consecutively 2 turns are not valid then it is an end.
                break;
        }
        i+=moves[currMoveIndex][0];
        j+=moves[currMoveIndex][1];
        
    }
    return res;
}

    public static boolean isNextBlockValid(boolean[][] visited, int i, int j, int[][] moves, int currMoveIndex, int m, int n){
        i+=moves[currMoveIndex][0];
        j+=moves[currMoveIndex][1];
        if(i>=m || j>=n || i<0 || j<0)
            return false;
        return !visited[i][j];
    }
}
