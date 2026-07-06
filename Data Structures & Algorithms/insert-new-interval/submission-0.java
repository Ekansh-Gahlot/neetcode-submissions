class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals)
        {
            list.add(interval);
        }
        list.add(newInterval);

        int[][] newArr = list.toArray(new int[list.size()][]);
        Arrays.sort(newArr, (a,b)->a[0]-b[0]);

        int startTime = newArr[0][0];
        int endTime = newArr[0][1];
        List<int[]> ans = new ArrayList<>();

        for(int i = 1; i < newArr.length; i++)
        {
            int currStartTime = newArr[i][0];
            int currEndTime = newArr[i][1];
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
