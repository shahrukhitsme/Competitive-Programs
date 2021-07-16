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
//Implemented this solution again a year later.
class Solution2 {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        int res = 1;
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i], -1);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int pathLen = traverse(matrix, i, j, -1);
                if(pathLen>res)
                    res = pathLen;
            }
        }
        return res;
    }
    
    public int traverse(int[][] matrix, int i, int j, int lastVal){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j] <= lastVal)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int down = traverse(matrix, i+1, j, matrix[i][j]);
        int top = traverse(matrix, i-1, j, matrix[i][j]);
        int right = traverse(matrix, i, j+1, matrix[i][j]);
        int left = traverse(matrix, i, j-1, matrix[i][j]);
        int max = Math.max(Math.max(top, down), Math.max(left, right))+1;
        dp[i][j] = max;
        return max;
    }
}