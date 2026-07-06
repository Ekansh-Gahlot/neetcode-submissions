class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count = 0;
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        for(int i = 1;  i < intervals.length; i++)
        {
            int nextStartTime = intervals[i][0];
            int nextEndTime = intervals[i][1];

            if(nextStartTime < endTime)
            {
                count++;
                endTime = Math.min(nextEndTime, endTime);
            }
            else{
                startTime = nextStartTime;
                endTime = nextEndTime;
            }
        
        }
        return count;   

    }
}
