/*
Question Link: https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1#
Approach: For any element the maximum non adjacent subsequence sum is equal to maximum of:
    1. Current value + dp value of last to last element
    2. dp value of last element
*/
class solve{
    // Function to return maximum of sum without adjacent elements
    public int FindMaxSum(int arr[], int n){
        int[] dp = new int[n];
        if(n<2)
            return arr[0];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}

/*
Question Link: https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1#
Approach: For any element the maximum non adjacent subsequence sum is equal to maximum of:
    1. Sum of subsequence including that element: current element + sum of subsequence excluding previous element
    2. Sum of subsequence excluding that element: Maximum of (Subsequence including previous element, Subsequence including previous to previous element).
*/
class solve2{
    // Function to return maximum of sum without adjacent elements
    public int FindMaxSum(int arr[], int n){
        int[][] inex = new int[2][n+1];
        inex[0][0] = 0;
        inex[1][0] = 1;
        for(int i=1; i<=n; i++){
            int arrInd = i-1;
            if(i==1){
                inex[0][i] = arr[arrInd];
                inex[1][i] = 0;
            }else{
                inex[0][i] = arr[arrInd]+inex[1][i-1];
                inex[1][i] = Math.max(inex[0][i-1], inex[0][i-2]);
            }
        }
        return Math.max(inex[0][n], inex[1][n]);
    }
}