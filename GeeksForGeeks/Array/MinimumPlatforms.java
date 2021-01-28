/*
Question Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/0/?track=md-arrays&batchId=144#
Approach: Created an array of length equal to number of minutes in a day, and incremented value at index=minute at which train
enters, and decremented when it leaves. So in this way when we do a prefix sum, we get the number of trains at any instance.
*/
class Platform
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        int[] times = new int[24*60+1];
        for(int i=0; i<n; i++){
            int arrIndex = ((arr[i]/100)*60) + (arr[i]%100);
            int depIndex = ((dep[i]/100)*60) + (dep[i]%100);
            times[arrIndex]++;
            times[depIndex+1]--;
        }
        int max=0;
        int count = 0;
        for(int i=0; i<times.length; i++){
            count+=times[i];
            if(count>max)
                max=count;
        }
        return max;
    }
}