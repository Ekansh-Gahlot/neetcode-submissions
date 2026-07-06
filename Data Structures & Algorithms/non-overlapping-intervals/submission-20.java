class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);


        int start = intervals[0][0];
        int end = intervals[0][1];
        int conflict = 0;
        for(int i = 1; i < intervals.length; i++)
        {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart < end){
                conflict++;
                end = Math.min(end, currEnd);
            }else{
                end = currEnd;
            }
        }
        return conflict;
    }
}
