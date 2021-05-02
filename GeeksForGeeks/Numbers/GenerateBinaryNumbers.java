/*
Question Link: https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon
Approach: used Integer.toBinaryString() function.
*/
class solve{
    static ArrayList<String> generate(int N)
    {
        ArrayList<String> res = new ArrayList<>();
        for(int i=1; i<=N; i++){
            res.add(Integer.toBinaryString(i));
        }
        return res;
    }
}