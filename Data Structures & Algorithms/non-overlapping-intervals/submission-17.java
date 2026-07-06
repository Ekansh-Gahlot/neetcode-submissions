class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int endTime = intervals[0][1];
        for(int i = 1; i < intervals.length; i++)
        {
            int currStartTime = intervals[i][0];
            int currEndTime = intervals[i][1];

            if(currStartTime < endTime)
            {
                endTime = Math.min(endTime, currEndTime);
                count++;
            }
            else{
                endTime = currEndTime;
            }
        }
        return count;
    }
}
