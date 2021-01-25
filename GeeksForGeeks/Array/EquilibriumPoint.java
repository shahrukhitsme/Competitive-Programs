/*
Question Link: https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/0/?track=md-arrays&batchId=144
Approach: Find total sum. Traverse array, and see if total sum - current value is double the sum yet. Then the equilibrium point is found.
*/
class EquilibriumPoint {

    // Function to find equilibrium point
    // a: input array
    // n: size of array
    public static int equilibriumPoint(long arr[], int n) {
        long sum = 0;
        for(long i:arr)
            sum+=i;
        long currSum = 0;
        for(int i=0; i<n; i++){
            if((sum-arr[i])%2==0 && ((sum-arr[i])/2==currSum))
                return i+1;
            currSum+=arr[i];
        }
        return -1;
    }
}