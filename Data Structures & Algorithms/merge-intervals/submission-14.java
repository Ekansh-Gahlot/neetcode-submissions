class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i = 1 ; i < intervals.length; i++)
        {
            int currStartTime = intervals[i][0];
            int currEndTime = intervals[i][1];

            if(currStartTime <= endTime)
            {
                //They overlap update endtime
                endTime = Math.max(endTime, currEndTime);
            }
            else{
                list.add(new int[]{startTime, endTime});
                startTime = currStartTime;
                endTime = currEndTime;
            }
        }

        list.add(new int[]{startTime, endTime});
        return list.toArray(new int[list.size()][]);
    }
}
