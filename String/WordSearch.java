/*
Question Link: https://leetcode.com/problems/word-search/
Approach: Recursion
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(word.charAt(0)==board[i][j]){
                    visited[i][j] = true;
                    if(check(board, word.substring(1, word.length()), visited, i+1, j)){
                        visited[i][j] = false;
                        return true;
                    }    
                    if(check(board, word.substring(1, word.length()), visited, i, j+1)){
                        visited[i][j] = false;
                        return true;
                    }   
                    if(check(board, word.substring(1, word.length()), visited, i-1, j)){
                        visited[i][j] = false;
                        return true;
                    }   
                    if(check(board, word.substring(1, word.length()), visited, i, j-1)){
                        visited[i][j] = false;
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, String word, boolean[][] visited, int i, int j){
        if(word.equals(""))
            return true;
        if(i<0 || i>= board.length || j<0 || j>=board[0].length)
            return false;
        if(visited[i][j])
            return false;
        if(word.charAt(0)!=board[i][j])
            return false;
        visited[i][j] = true;
        if(check(board, word.substring(1, word.length()), visited, i+1, j)){
            visited[i][j] = false;
            return true;
        }    
        if(check(board, word.substring(1, word.length()), visited, i, j+1)){
            visited[i][j] = false;
            return true;
        }   
        if(check(board, word.substring(1, word.length()), visited, i-1, j)){
            visited[i][j] = false;
            return true;
        }   
        if(check(board, word.substring(1, word.length()), visited, i, j-1)){
            visited[i][j] = false;
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}