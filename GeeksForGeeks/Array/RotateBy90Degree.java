/*
Question Link: https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon#
Approach: Copied data row and columnwise from complimentary rotated row column.
*/
class GFG
{
    static void rotate(int matrix[][]) 
    {
        int N = matrix.length;
        int[] temp = new int[N];
        for(int i=0; i<N/2; i++){
            for(int j=i; j<N-i; j++)
                temp[j] = matrix[i][j];
            for(int j=i; j<N-i; j++)
                matrix[i][j] = matrix[j][N-i-1];
            for(int j=i; j<N-i; j++)
                matrix[j][N-i-1] = matrix[N-i-1][N-j-1];
            for(int j=i; j<N-i; j++)
                matrix[N-i-1][N-j-1] = matrix[N-j-1][i];
            for(int j=i; j<N-i; j++)
                matrix[N-j-1][i] = temp[j];
        }
    }
}