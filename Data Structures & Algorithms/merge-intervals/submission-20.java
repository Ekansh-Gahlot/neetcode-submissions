class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart <= endTime){
                endTime = Math.max(endTime, currEnd);
            }
            else{
                list.add(new int[]{startTime, endTime});
                startTime = currStart;
                endTime = currEnd;
            }
        }
        list.add(new int[]{startTime, endTime});

        int[][] result =  list.toArray(new int[list.size()][]);
        return result;
    }
}
