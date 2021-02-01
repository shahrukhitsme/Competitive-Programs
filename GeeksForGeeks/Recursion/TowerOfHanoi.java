/*
Question Link: https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/0/?track=md-recursion&batchId=144#
Approach: 
1. Transfer N-1 discs from to aux
2. Transfer last disc from to to
3. Transfer N-1 discs aux to to
In the base case when N is 1, print the step.
*/
class Hanoi {

    public long toh(int N, int from, int to, int aux) {
        return transfer(N, from, to, aux, 1);
    }
    
    public long transfer(int N, int from, int to, int aux, int topDisc) {
        if(N==1){
            print(topDisc, from, to);
            return 1;
        }
        return transfer(N-1, from, aux, to, topDisc) +
        transfer(1, from, to, aux, topDisc+1) +
        transfer(N-1, aux, to, from, topDisc);
    }
    
    public void print(int a, int b, int c){
        System.out.println("move disk "+a+" from rod "+b+" to rod "+c);
    }
}