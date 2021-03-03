// package whatever; // don't place package name!

import java.io.*;
class Node{
  int data;
  Node next;
  Node random;
  Node(){
    data = 0;
    next = null;
    random = null;
  }
  Node(int d, Node nextRef){
    data = d;
    next = nextRef;
    random = null;
  }
}

class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java");
	}
  
  public static Node clone(Node head){
    if(head == null)
      return null;
      
    Node temp = head;
    //Creating newNodes
    while(temp!=null){
      Node newNode = new Node(temp.data, temp.next);
      temp.next = newNode;
      temp=newNode.next;
    }
    
    temp = head;
    while(temp!=null){
      if(temp.random == null)
        temp.next.random = null;
      else
        temp.next.random = temp.random.next;
      temp = temp.next.next;
    }
    
    temp = head;
    Node resHead, temp2;
    resHead = temp.next;
    temp2 = resHead;
    while(temp!=null){
      temp.next = temp.next.next;
      if(temp2.next!=null)
        temp2.next = temp2.next.next;
      temp = temp.next;
      temp2 = temp2.next;
    }
    return resHead;
  }
}



// create mirror image of a binary tree such that right most nodes 
// of the tree are conected



//     1 
//    / \
//   2   3


//     1   1
//    / \ / \
//   2   3   2
 
//     1 
//    / \
//   2   3
//    \
//     4
//      \
//       5


//     1   1
//    / \ / \
//   2   3   2
//    \     /
//     4   4
//      \ /
//       5
 
//     1 
//    / \
//   2   3
//      /
//     4
//      \
//       5
 
//     1   1
//    / \ / \
//   2   3   2
//      / \  
//     4   4
//      \ /
//       5

//   1
//  /
// 2

//   1
//  / \
// 2   2

/*
Step1: Finding the maximum right distance
Step2: Recursively, clone tree, left will become cloned right and vice verse,
  2.1 : if the current node is having max right distance, 
        dont call the function on right tree only call on left,
  2.2:; else create a new node and call the recur function 
        recursily for right and left subtree

*/
public static Node createMirror(Node root){
  //int maxRight = getMaxRight();
  int maxRightDist = 2;  //sample
  if(maxRightDist==0)
  return recur(root, 0, maxRightDist);
}

public static Node recur(Node root, int currDist, int maxRightDist){
  if(root == null)
    return null;
    
  Node newNode;
  if(currDist != maxRightDist){
    newNode = new Node(root.data);
    newNode.left = recur(root.right, currDist+1, maxRightDist);
  }
  else 
    newNode = root;
  
  newNode.right = recur(root.left, currDist-1, maxRightDist);
  return newNode;
}