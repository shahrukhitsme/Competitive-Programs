/*
Question Link: https://leetcode.com/problems/max-area-of-island/
Approach: Traverse the array and mark nodes visited and for each node recursively go to adjacent cells, and if they are 1 too and not visited also, then add to area and move to more adjacent recursively.
*/
class Solution {
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int area = traverse(grid, i, j);
                if(area > max)
                    max = area;
            }
        }
        return max;
    }
    
    public int traverse(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
        if(grid[i][j]==0 || visited[i][j])
            return 0;
        int res = 1;
        visited[i][j] = true;
        res+=traverse(grid, i, j+1);
        res+=traverse(grid, i, j-1);
        res+=traverse(grid, i+1, j);
        res+=traverse(grid, i-1, j);
        return res;
    }
}