/*
Question Link: https://leetcode.com/problems/surrounded-regions/
Approach: DFS from boundary Os and mark them as immutable. Reverse the rest of the Os.
*/
class Solution {
    boolean[][] visited;
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0 || board.length==1 || board[0].length==1)
            return;
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i=i+board.length-1){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='O' && visited[i][j]==false)
                    mark(board, i, j);
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j=j+board[0].length-1){
                if(board[i][j]=='O' && visited[i][j]==false)
                    mark(board, i, j);
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(visited[i][j]==false)
                    board[i][j]='X';
            }
        }
    }
    
    public void mark(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;
        if(board[i][j]=='O' && visited[i][j]==false){
            visited[i][j]=true;
            mark(board, i-1, j);
            mark(board, i+1, j);
            mark(board, i, j-1);
            mark(board, i, j+1);
        }
    }
}