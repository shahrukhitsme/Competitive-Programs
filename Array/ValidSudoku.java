/*
Question Link: https://leetcode.com/problems/valid-sudoku/
Approach1: Create 3 keys based on row, column, box and put entry in set. If entry already exists, return false. Finally return true.
Total access count = 81
Approach2: Check all rows, columns, and boxes.
Total access count = 81*3 = 243
*/
//Approach1:
class Solution {
	public boolean isValidSudoku(char[][] board) {
		Set seen = new HashSet();
		for (int i=0; i<9; ++i) {
			for (int j=0; j<9; ++j) {
				char number = board[i][j];
				if (number != '.')
					if (!seen.add(number + " in row " + i) ||
						!seen.add(number + " in column " + j) ||
						!seen.add(number + " in block " + i/3 + "-" + j/3))
						return false;
			}
		}
		return true;
	}
}

//Approach2:
/* 
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] temp;
        int index;
        for(char[] row: board){
            temp = new int[9];
            for(char rowElem: row){
                if(rowElem!='.'){
                    index = rowElem-'1';
                    if(temp[index]==1)
                        return false;
                    temp[index]=1;
                }
            }
        }
        for(int i=0; i<9; i++){
            temp = new int[9];
            for(int j=0; j<9; j++){
                if(board[j][i]!='.'){
                    index = board[j][i]-'1';
                    if(temp[index]==1)
                        return false;
                    temp[index]=1;
                }
            }
        }
        int x,y;
        for(int i=0; i<9; i=i+3){
            for(int j=0; j<9; j=j+3){
                temp = new int[9];
                x=i;
                y=j;
                for(int k=0; k<9; k++){
                    x = i+k/3;
                    y = j+k%3;
                    if(board[x][y]!='.'){
                        index = board[x][y] - '1';
                        if(temp[index]==1)
                            return false;
                        temp[index]=1;
                    }
                }
            }
        }
        return true;
    }
}
*/