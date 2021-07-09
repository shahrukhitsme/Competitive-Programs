/*
Question Link: https://leetcode.com/problems/number-of-closed-islands/
Approach: Just traversed and marked visited and counted distinct closed islands.
*/
class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res=0;
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                boolean[][] tempVis = new boolean[m][n];
                if(visited[i][j]==false && grid[i][j]==0){
                    boolean closed = isClosed(i, j, grid, visited, tempVis);
                    res+=closed?1:0;
                    //System.out.println(i+" "+j+" : "+closed);
                }
            }
        }
        return res;
    }
    
    public boolean isClosed(int i, int j, int[][] grid, boolean[][] visited, boolean[][] tempVis){
        if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
            return (grid[i][j]==1);
        }
        if(grid[i][j]==1)
            return true;
        if(tempVis[i][j])
            return true;
        if(visited[i][j])
            return false;
        tempVis[i][j]=true;
        boolean res1 = isClosed(i-1, j, grid, visited, tempVis);
        boolean res2 = isClosed(i, j-1, grid, visited, tempVis);
        boolean res3 = isClosed(i+1, j, grid, visited, tempVis);
        boolean res4 = isClosed(i, j+1, grid, visited, tempVis);
        //System.out.println(i+" "+j+" : "+res1+" "+res2+" "+res3+" "+res4);
        visited[i][j]=true;
        return res1 && res2 && res3 && res4;
    }
}