/*
Question Link: https://leetcode.com/problems/where-will-the-ball-fall/
Approach: For each ball track it and find the drop index.
*/
class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = new int[m][n];
        int[] res = new int[grid[0].length];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((j==0 && grid[i][0]==-1) || (j==n-1 && grid[i][n-1]==1))
                    dir[i][j] = 0;
                else if(j==0){
                    if(grid[i][j+1]==-1)
                        dir[i][j] = 0;
                    else
                        dir[i][j] = 1;
                }
                else if(j==n-1){
                    if(grid[i][n-2]==1)
                        dir[i][j] = 0;
                    else
                        dir[i][j] = -1;
                }
                else{
                    if((grid[i][j]==1 && grid[i][j+1]==1) || (grid[i][j]==-1 && grid[i][j-1]==-1))
                        dir[i][j] = grid[i][j];
                    else
                        dir[i][j] = 0;
                }
            }
        }
        for(int j=0; j<n; j++){
            res[j] = getDropIndex(0, j, dir);
        }
        return res;
    }
    
    public int getDropIndex(int i, int j, int[][] dir){
        if(dir[i][j]==0)
            return -1;
        if(i>=dir.length-1)
            return j+dir[i][j];
        
        return getDropIndex(i+1, j+dir[i][j], dir);
    }
}