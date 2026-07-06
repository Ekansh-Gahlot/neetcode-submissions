class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        for(int[] i: intervals){
            temp.add(i);
        }
        temp.add(newInterval);
        int[][] newIntervals = temp.toArray(new int[temp.size()][]);

        Arrays.sort(newIntervals, (a,b)->Integer.compare(a[0],b[0]));

        int start = newIntervals[0][0];
        int end = newIntervals[0][1];
        List<int[]> list = new ArrayList<>();

        for(int i = 1; i < newIntervals.length; i++){
            int currStart = newIntervals[i][0];
            int currEnd = newIntervals[i][1];

            if(currStart <= end){
                end = Math.max(currEnd, end);
            }else{
                list.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}
