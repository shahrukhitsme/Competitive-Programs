/*
Question Link: https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/0/?track=md-recursion&batchId=144
Approach: Iterate 4 ways by checking bounds and the criteria, and also check that the iteration does not loop back
*/
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int rows = image.length;
        int columns = image[0].length;
        int[][] res = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++)
                res[i][j] = image[i][j];
        }
        changePixel(image, res, sr, sc, image[sr][sc], newColor, rows, columns);
        return res;
    }
    
    public void changePixel(int[][] image, int[][]res, int i, int j, int color, int newColor, int rows, int columns){
        res[i][j]=newColor;
        image[i][j]=-1;
        if(i+1<rows && image[i+1][j]==color){
            changePixel(image, res, i+1, j, color, newColor, rows, columns);
        }
        if(j+1<columns && image[i][j+1]==color){
            changePixel(image, res, i, j+1, color, newColor, rows, columns);
        }
        if(i-1>=0 && image[i-1][j]==color){
            changePixel(image, res, i-1, j, color, newColor, rows, columns);
        }
        if(j-1>=0 && image[i][j-1]==color){
            changePixel(image, res, i, j-1, color, newColor, rows, columns);
        }
    }
}