/*
Question Link: https://leetcode.com/problems/spiral-matrix/
Approach: Go right until end/visited, then go down until end or visited, then go left until end or visited, then go up, until end or visited, the again left, and so on. Keep marking the
nodes visited. Also check if there is no way, break.
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0)
            return spiral;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        move(matrix, 0, 0, 'r', spiral, visited);
        return spiral;
    }
    
    public void move(int[][] matrix, int i, int j, char dir, List<Integer> spiral, boolean[][] visited){
        spiral.add(matrix[i][j]);
        visited[i][j] = true;
        if(dir=='r'){//right
            if(j+1<matrix[0].length && visited[i][j+1]==false)
                move(matrix, i, j+1, 'r', spiral, visited);
            else if(i+1<matrix.length && visited[i+1][j]==false)
                move(matrix, i+1, j, 'd', spiral, visited);
        }
        else if(dir=='l'){//left
            if(j-1>=0 && visited[i][j-1]==false)
                move(matrix, i, j-1, 'l', spiral, visited);
            else if(i-1>=0 && visited[i-1][j]==false)
                move(matrix, i-1, j, 'u', spiral, visited);
        }
        else if(dir=='d'){//down
            if(i+1<matrix.length && visited[i+1][j]==false)
                move(matrix, i+1, j, 'd', spiral, visited);
            else if(j-1>=0 && visited[i][j-1]==false)
                move(matrix, i, j-1, 'l', spiral, visited);
        }
        else{//up
            if(i-1>=0 && visited[i-1][j]==false)
                move(matrix, i-1, j, 'u', spiral, visited);
            else if(j+1<matrix[0].length && visited[i][j+1]==false)
                move(matrix, i, j+1, 'r', spiral, visited);
        }
    }
}