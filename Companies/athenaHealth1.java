/*
BOOK_TABLE
book_id, book_name, book_count, ..
1       HP1         3
2       HP2         2
3       AB          0
4       YZ          1

USER_TABLE
user_id, user_name, ...
1       user1
2       user2
3       user3

LOAN_TABLE
user_id, book_id, timestamp
1       2         1221021212
3       3         1421021315
1       3         1421021315

Show all users and number of books they have taken
*/


//Find minimum of 3 numbers without using any conditional operators
int min(int a, int b, int c){
    int min=0;
    while(a && b && c){
        a--;
        b--;
        c--;
        min++;
    }
    return min;
}

//Given an array, find the equilibrium index. An equilibrium index is one, which has the product of elements to it's left equal to the product of elements to it's right
/*
arr = [4, 3, 1, 2, 9, 6, 4]
a =   [4, 12, 12, 24, 216, 1296, 5184]
b =   [5184 , 1296 , 432, 432 , 216, 24, 4]

        0     1    2   3
arr =   [2,   3,   9,  6]
a=      [2,   6,   54, 324]
b=      [324, 162, 54, 6]
len=4
*/
int findEquilibriumPoint(int[] arr){
    int len = arr.length;
    if(len==0)
        return -1;
    int[] a = new int[len];
    int[] b = new int[len];
    a[0] = arr[0];
    b[len-1] = arr[len-1];
    for(int i=1; i<len; i++){
        int leftIndex = i;
        int rightIndex = len-1-i;
        a[leftIndex] = a[leftIndex-1] * arr[leftIndex];
        b[rightIndex] = b[rightIndex+1] * arr[rightIndex];
    }

    for(int i=1; i<len-1; i++){
        if(a[i-1]==b[i+1])
            return i;
    }
    return -1;
}