class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[queries.length];
        int i = 0;
        for(int q: sortedQueries)
        {
            //Add all intervals whose start < q
            while(i < intervals.length && intervals[i][0] <= q)
            {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.add(new int[]{(r-l+1),r});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q)
            {
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        
        for(int k = 0; k < queries.length; k++){
            ans[k] = map.get(queries[k]);
        }
        return ans;
    }
}
