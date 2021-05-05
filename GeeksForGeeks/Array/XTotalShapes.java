/*
Question Link: https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: Keep marking visited positions, and for each position expand till you keep finding X. And then do the same for next X and increase the count.
*/
class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='X'){
                    count++;
                    markVisited(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void markVisited(char[][] grid, int x, int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!='X')
            return;
            grid[x][y] = 'O';
        markVisited(grid, x+1, y);
        markVisited(grid, x, y+1);
        markVisited(grid, x-1, y);
        markVisited(grid, x, y-1);
    }
}