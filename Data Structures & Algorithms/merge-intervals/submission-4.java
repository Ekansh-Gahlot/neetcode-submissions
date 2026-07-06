class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart <= currEnd)
            {
                currEnd = Math.max(currEnd,nextEnd);
            }
            else{
                list.add(new int[]{currStart,currEnd});
                currStart = nextStart;
                currEnd = nextEnd;
            }
        }
        list.add(new int[]{currStart,currEnd});
        return list.toArray(new int[list.size()][]);
    }
}
