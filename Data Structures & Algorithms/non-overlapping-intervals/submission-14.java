class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int currEndTime = intervals[0][1];
        int count = 0;
        for(int i = 0 ; i < intervals.length-1; i++){
            int nextStartTime = intervals[i+1][0];
            int nextEndTime = intervals[i+1][1];
            if(nextStartTime < currEndTime)
            {
                //overlap conflict
                currEndTime = Math.min(currEndTime, nextEndTime);
                count++;
            }
            else{
                currEndTime = nextEndTime;
            }
       }
       return count;
    }
}
