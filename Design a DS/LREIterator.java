/*
Question Link: https://leetcode.com/problems/rle-iterator/
Approach: Keep reference to current index in the encoding, and for each next, check if index is already out of bounds, return -1, else traverse the encoding array till we get the required number and update index and update encoding array and return the answer.
*/
class RLEIterator {
    int[] encoding;
    int index;
    
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;
    }
    
    public int next(int n) {
        if(index>=encoding.length)
            return -1;
        while(true){
            int num = encoding[index];
            if(num>=n){
                encoding[index] -= n;
                int res=encoding[index+1];
                if(encoding[index]==0)
                    index+=2;
                return res;
            }
            else{
                n-=encoding[index];
                encoding[index]=0;
                index+=2;
            }
            if(index>=encoding.length)
                return -1;
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */