/*
Question Link: https://leetcode.com/problems/number-of-islands/
Approach: Create a 2d boolean array for marking the elements that are visited. Traverse the arraty, and start from each unvisited element, thereby increasing the count by 1, 
and keep marking all unvisited adjacent indices as visited using recursion.
*/
class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int r = grid.length;
        if(r==0)
            return 0;
        int c = grid[0].length;
        visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]!='0' && visited[i][j]==false){
                    numOfIslands++;
                    markVisited(i, j, grid);
                }
            }
        }
        return numOfIslands;
    }
    
    public void markVisited(int i, int j, char[][] grid){
        visited[i][j] = true;
        if(j-1>=0 && grid[i][j-1]=='1' && visited[i][j-1]==false)
            markVisited(i, j-1, grid);
        if(j+1<grid[0].length && grid[i][j+1]=='1' && visited[i][j+1]==false)
            markVisited(i, j+1, grid);
        if(i-1>=0 && grid[i-1][j]=='1' && visited[i-1][j]==false)
            markVisited(i-1, j, grid);
        if(i+1<grid.length && grid[i+1][j]=='1' && visited[i+1][j]==false)
            markVisited(i+1, j, grid);
    }
}