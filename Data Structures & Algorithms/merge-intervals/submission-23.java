class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i: intervals){
            int currStart = i[0];
            int currEnd = i[1];

            if(currStart <= end){
                end = Math.max(currEnd, end);
                continue;
            }

            list.add(new int[]{start, end});
            start = currStart;
            end = currEnd;

        }
        list.add(new int[]{start,end});

        return list.toArray(new int[list.size()][]);
    }
}
