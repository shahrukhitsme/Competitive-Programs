/*
Question Link: https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/0/?track=md-arrays&batchId=144
Approach: Count 0s, 1s, and 2s, and fill them accordingly in the array.
*/
public static void sort012(int a[], int n){
    int count_0=0, count_1=0, count_2=0;
    for(int i: a){
        switch(i){
            case 0:
                count_0++;
                break;
            case 1:
                count_1++;
                break;
            default:
                count_2++;
        }
    }
    int i=0;
    for(; i<count_0; i++)
        a[i]=0;
    for(; i<count_0+count_1; i++)
        a[i]=1;
    for(; i<count_0+count_1+count_2; i++)
        a[i]=2;
}