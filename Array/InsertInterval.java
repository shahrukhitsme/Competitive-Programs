/*
Question Link: https://leetcode.com/problems/insert-interval/
Approach: Using binary search found the positions where new intervals start and end would be placed. Then found whether those intervals are overlapping or not. And if yes, then also found out whether they are overlapping with the previous interval or the next interval. Then traversed through the intervals and added the new interval and merged accordingly.
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        int startIndex = find(0, intervals.length-1, intervals, newInterval[0]);
        int endIndex = find(0, intervals.length-1, intervals, newInterval[1]);
        List<List<Integer>> intervalList = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            intervalList.add(temp);
        }
        
        boolean overlap1=false, overlap2=false, prevlap1=false, prevlap2=false;
        if(startIndex>0 && newInterval[0]<=intervals[startIndex-1][1]){
            overlap1 = true;
            prevlap1 = true;
        }
        else if(startIndex<intervals.length && newInterval[0]==intervals[startIndex][0])
            overlap1 = true;
        
        if(endIndex>0 && newInterval[1]<=intervals[endIndex-1][1]){
            overlap2 = true;
            prevlap2 = true;
        }
        else if(endIndex<intervals.length && newInterval[1]==intervals[endIndex][0])
            overlap2 = true;
        //System.out.println(startIndex+" "+endIndex);
        //System.out.println(overlap1+" "+overlap2+" "+prevlap1+" "+prevlap2);
        
        List<List<Integer>> resList = new ArrayList<>();
        for(int i=0; i<startIndex-1; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            resList.add(temp);
        }
        
        if(!prevlap1 && startIndex>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[startIndex-1][0]);
            temp.add(intervals[startIndex-1][1]);
            resList.add(temp);
        }
        
        List<Integer> intervalFinal = new ArrayList<>();
        
        if(overlap1){
            if(prevlap1){
                intervalFinal.add(intervals[startIndex-1][0]);
            }else{
                intervalFinal.add(intervals[startIndex][0]);
            }
        }else{
            intervalFinal.add(newInterval[0]);
        }
        
        if(overlap2){
            if(prevlap2){
                intervalFinal.add(intervals[endIndex-1][1]);
            }else{
                intervalFinal.add(intervals[endIndex][1]);
            }
        }else{
            intervalFinal.add(newInterval[1]);
        }
        
        resList.add(intervalFinal);
        
        int continuationIndex = endIndex;
        if(overlap2 && !prevlap2)
            continuationIndex++;
        
        for(int i=continuationIndex; i<intervals.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            resList.add(temp);
        }
        
        int[][] res = new int[resList.size()][2];
        for(int i=0; i<resList.size(); i++){
            int[] temp = new int[2];
            temp[0] = resList.get(i).get(0).intValue();
            temp[1] = resList.get(i).get(1).intValue();
            res[i] = temp;
        }
        return res;
    }
    
    public int find(int start, int end, int[][] intervals, int key){
        if(start==end){
            if(key <= intervals[start][0])
                return start;
            return start+1;
        }
        if(start==end-1){
            if(key <= intervals[start][0])
                return start;
            else if(key > intervals[start][0] && key <= intervals[end][0])
                return end;
            else return end+1;
        }
        int mid = (start+end)/2;
        if(key>intervals[mid][0]){
            return find(mid, end, intervals, key);
        }
        else if(key<intervals[mid][0]){
            return find(start, mid, intervals, key);
        }
        else{
            return mid;
        }
    }
}

/*
//Other Approach: Just traverse linearly and use link list for better operation.
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    // init data
    int newStart = newInterval[0], newEnd = newInterval[1];
    int idx = 0, n = intervals.length;
    LinkedList<int[]> output = new LinkedList<int[]>();

    // add all intervals starting before newInterval
    while (idx < n && newStart > intervals[idx][0])
      output.add(intervals[idx++]);

    // add newInterval
    int[] interval = new int[2];
    // if there is no overlap, just add the interval
    if (output.isEmpty() || output.getLast()[1] < newStart)
      output.add(newInterval);
    // if there is an overlap, merge with the last interval
    else {
      interval = output.removeLast();
      interval[1] = Math.max(interval[1], newEnd);
      output.add(interval);
    }

    // add next intervals, merge with newInterval if needed
    while (idx < n) {
      interval = intervals[idx++];
      int start = interval[0], end = interval[1];
      // if there is no overlap, just add an interval
      if (output.getLast()[1] < start) output.add(interval);
      // if there is an overlap, merge with the last interval
      else {
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], end);
        output.add(interval);
      }
    }
    return output.toArray(new int[output.size()][2]);
  }
}
*/