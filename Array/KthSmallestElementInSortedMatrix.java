/*
Question Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Approach: Starting from top left, we have to keep track of possible smallest value in the remaining set. And remove it from the remaining set to get the next smallest. This is achieved
using a minHeap.
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        int i=0, n=matrix.length;
        while(i<n && i<k){
            minHeap.add(new Node(i,0));
            i++;
        }
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
          Node node = minHeap.poll();
          result = matrix[node.row][node.col];
          if (++numberCount == k)
            break;
          node.col++;
          if (matrix[0].length > node.col)
            minHeap.add(node);
        }
        return result;
    }
}

class Node {
  int row;
  int col;

  Node(int row, int col) {
    this.row = row;
    this.col = col;
  }
}