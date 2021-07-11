/*
Question Link: https://leetcode.com/problems/valid-square/
Approach: Find the correct order of sides. Match sides and diagonals. Catch: No need to do any square root operation to avoid decimal errors.
*/
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double side1 = findLength(p1, p2);
        double side2 = findLength(p1, p3);
        double side3 = findLength(p1, p4);
        int[] p,q,r,s;
        double correctSide=side1;
        if(side1==0 || side2==0 || side3==0)
            return false;
        if(side1==side2 && side1==side3)
            return false;
        if(side1==side2){
            p=p1; q=p2; r=p4; s=p3;
        }
        else if(side1==side3){
            p=p1; q=p2; r=p3; s=p4;
        }
        else if(side2==side3){
            p=p1; q=p3; r=p2; s=p4;
            correctSide = side2;
        }
        else
            return false;
        if(correctSide!=findLength(r,s) || correctSide!=findLength(q,r))
            return false;
        if(findLength(q,s)!=findLength(p,r))
            return false;
        return true;
    }
    
    public double findLength(int[] p, int[] q){
        int px = p[0], py=p[1], qx=q[0], qy=q[1];
        double distance = (Math.pow(qx-px, 2)+Math.pow(qy-py, 2));
        return distance;
    }
}