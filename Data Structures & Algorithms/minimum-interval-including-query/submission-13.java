class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for(int q: sortedQueries)
        {
            while(j < intervals.length && intervals[j][0] <= q){
                int l = intervals[j][0];
                int r = intervals[j][1];
                minHeap.add(new int[]{r-l+1,r});
                j++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int ans[] = new int[queries.length];
        for(int i = 0 ; i < ans.length; i++){
            ans[i] = map.get(queries[i]);
        }
        return ans;
    }
}
