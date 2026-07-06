class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int intervalsToRemove = 0;
        int currentEndTime = intervals[0][1];
        int count = 0;
        for(int i = 0 ; i < intervals.length-1; i++)
        {
            int nextStartTime = intervals[i+1][0];
            int nextEndTime = intervals[i+1][1];

            if(currentEndTime > nextStartTime)
            {   
                //meaning they overlap
                currentEndTime = Math.min(currentEndTime, nextEndTime);
                count++;
            }
            else{
                    currentEndTime = nextEndTime;
                }
        }
        return count;

    }
}
