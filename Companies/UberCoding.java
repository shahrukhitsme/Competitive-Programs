/*
There has been a lot of hype recently about Uber's new product. Suppose you are managing the construction of billboards on a freeway, a heavily-travelled stretch of road that runs for M miles, in order promote this new product for Uber. The possible sites for Uber's billboards are given by numbers x1, x2, ..., xn, each in the interval [0, M] (specified by their position along the highway measured in miles from its western end). If you place a billboard at location xi , you receive a revenue of ri > 0 You want to place billboards at a subset of the sites in {x1, ..., xn} so as to maximize your total revenue, subject to the following restrictions:

Environmental Constraint. You cannot build two billboards within less than 5 miles of one another on the highway.
Boundary Constraint. You cannot build a billboard within less than 5 miles of the western or eastern ends of the highway.
A subset of sites satisfying these two restrictions will be called valid. Example Suppose M = 20, n = 4

{x1, x2, x3, x4} = {6, 8, 12, 14}
and
{r1, r2, r3, r4} = {5, 6, 5, 1}
Then the optimal solution would be to place billboards at x1 and x3 for a total revenue of 10. Give an algorithm of running time polynomial in n, that takes an instance of this problem as input, and returns the maximum total revenue that can be obtained from any valid subset of sites.

[execution time limit] 3 seconds (java)

[input] array.integer sites

[input] array.integer revenues

[input] integer m

[output] integer
*/

int[] dp;

int billboards(int[] sites, int[] revenues, int m) {
    dp = new int[sites.length];
    for(int i=0; i<sites.length; i++)
        dp[i]=-1;
        
    
    HashMap<Integer, Integer> revenuesMap = new HashMap<>();
    for(int i=0; i<sites.length; i++)
        revenuesMap.put(sites[i], revenues[i]);
    Arrays.sort(sites);
    int maxRevenue = getRevenue(0, 0, sites, revenuesMap, m);
        
    return maxRevenue;
}

int getRevenue(int lastMile, int currIndex, int[] sites, HashMap<Integer, Integer> revenuesMap, int m){
    if(currIndex>=sites.length)
        return 0;
    int currRevenue = revenuesMap.get(sites[currIndex]);
    int choosingCurr = currRevenue;
    if(sites[currIndex]-lastMile >= 5 && m-sites[currIndex] >=5){
        if(dp[currIndex]!=-1)
            choosingCurr = dp[currIndex];
        else{
            choosingCurr = currRevenue + getRevenue(sites[currIndex], currIndex+1, sites, revenuesMap, m);
        dp[currIndex] = choosingCurr;
        }
    }
    int notChoosingCurr = getRevenue(lastMile, currIndex+1, sites, revenuesMap, m);
    if(sites[currIndex]-lastMile >= 5 && m-sites[currIndex] >=5)
        return Math.max(choosingCurr, notChoosingCurr);
    return notChoosingCurr;
}
