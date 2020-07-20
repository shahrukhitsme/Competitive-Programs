/*
Question Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
Approach: A DFS combined with DP.
*/
class Solution {
    boolean[][] visited;
    int[][] answers;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        visited = new boolean[matrix.length][matrix[0].length];
        answers = new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(!visited[i][j]){
                    int temp = longestPathFromHere(i, j, matrix);
                    if(temp>max)
                        max=temp;
                }
            }
        }
        return max;
    }
    
    public int longestPathFromHere(int i, int j, int[][] matrix){
        if(visited[i][j])
            return answers[i][j];
        visited[i][j] = true;
        int a=1,b=1,c=1,d=1;
        if(i+1<matrix.length && matrix[i][j]<matrix[i+1][j])
            a=longestPathFromHere(i+1, j, matrix)+1;
        if(i-1>=0 && matrix[i][j]<matrix[i-1][j])
            b=longestPathFromHere(i-1, j, matrix)+1;
        if(j+1<matrix[0].length && matrix[i][j]<matrix[i][j+1])
            c=longestPathFromHere(i, j+1, matrix)+1;
        if(j-1>=0 && matrix[i][j]<matrix[i][j-1])
            d=longestPathFromHere(i, j-1, matrix)+1;
        answers[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
        return answers[i][j];
    }
}