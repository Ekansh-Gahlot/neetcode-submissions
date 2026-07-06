class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals)
        list.add(interval);
        list.add(newInterval);

        list.sort(Comparator.comparingInt((a)->a[0]));

        int[][] newArray = list.toArray(new int[list.size()][]);

        int startTime = newArray[0][0];
        int endTime = newArray[0][1];

        List<int[]> ans = new ArrayList<>();

        
        for(int i = 1; i < newArray.length; i++){
            int currStartTime = newArray[i][0];
            int currEndTime = newArray[i][1];

            if(currStartTime <= endTime)
            {
                endTime = Math.max(endTime, currEndTime);
            }
            else{
                ans.add(new int[]{startTime, endTime});
                startTime = currStartTime;
                endTime = currEndTime;
            }
        }
        ans.add(new int[]{startTime, endTime});
        return ans.toArray(new int[ans.size()][]);
    }
}
