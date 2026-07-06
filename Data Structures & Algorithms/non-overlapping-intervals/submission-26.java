class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart < end){
                end = Math.min(end, currEnd);
                count++;

            }
            else{
                start = currStart;
                end = currEnd;
            }
        }
        return count;
    }
}
