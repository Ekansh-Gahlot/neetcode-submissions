class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] current = intervals[0];
        mergedIntervals.add(current);
        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            if(next[0] <= current[1]){
                //overlap
                current[1] = Math.max(current[1], next[1]);
            }
            else{
                current = next;
                mergedIntervals.add(current);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
