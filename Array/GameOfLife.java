/*
Question Link: https://leetcode.com/problems/game-of-life/
Approach: Just used dummy values to save current value as well as new value. Like from 0 to 1 is 2, 1 to 1 is 1, 0 to 0 is 0, 1 to 0 is -1.
*/
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        if(m==1&&n==1){
            board[0][0]=0;
            return;
        }
        int[][] extended_board = new int[m+2][n+2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                 if(board[i][j]==1)
                    extended_board[i+1][j+1] = -9;
        }
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(extended_board[i][j]==-9||extended_board[i][j]>0){
                    extended_board[i-1][j-1] = getValue(extended_board[i-1][j-1]);
                    extended_board[i-1][j] = getValue(extended_board[i-1][j]);
                    extended_board[i-1][j+1] = getValue(extended_board[i-1][j+1]);
                    extended_board[i][j-1] = getValue(extended_board[i][j-1]);
                    extended_board[i][j+1] = getValue(extended_board[i][j+1]);
                    extended_board[i+1][j-1] = getValue(extended_board[i+1][j-1]);
                    extended_board[i+1][j] = getValue(extended_board[i+1][j]);
                    extended_board[i+1][j+1] = getValue(extended_board[i+1][j+1]);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(extended_board[i+1][j+1] == -3)
                    board[i][j]=1;
                else if(extended_board[i+1][j+1]<2 || extended_board[i+1][j+1]>3)
                    board[i][j]=0;
                else
                    board[i][j]=1;
            }
        }
    }
    
    public int getValue(int val){
        return val<=0&&val!=-9?(val-1):val==-9?1:(val+1);
    }
}