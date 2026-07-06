class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] sortedArray = Arrays.copyOf(intervals, intervals.length+1);
        sortedArray[sortedArray.length-1] = newInterval;
        Arrays.sort(sortedArray, (a,b)->Integer.compare(a[0],b[0]));

        //This problem now become Merge Intervals

        List<int[]> list = new ArrayList<>();
        int startTime = sortedArray[0][0];
        int endTime = sortedArray[0][1];
        for(int i = 1; i < sortedArray.length; i++)
        {
            int currStart = sortedArray[i][0];
            int currEnd = sortedArray[i][1];

            if(currStart <= endTime){
                endTime = Math.max(endTime, currEnd);
            }else{
                list.add(new int[]{startTime, endTime});
                startTime = currStart;
                endTime = currEnd;
            }
        }
        list.add(new int[]{startTime, endTime});

        return list.toArray(new int[list.size()][]);

    }
}
