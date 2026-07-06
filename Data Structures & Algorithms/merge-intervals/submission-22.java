class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart <= endTime){
                endTime = Math.max(endTime, currEnd);
            }
            else{
                 res.add(new int[]{startTime, endTime});
                startTime = currStart;
                endTime = currEnd;
                
            }
            
           
            
        }
        res.add(new int[]{startTime, endTime});
        return res.toArray(new int[res.size()][]);
    }
}
