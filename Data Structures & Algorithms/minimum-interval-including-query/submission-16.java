class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for(int q: sortedQueries){
            while(j < intervals.length && intervals[j][0] <= q){
                int left = intervals[j][0];
                int right = intervals[j][1];
                minHeap.add(new int[]{(right-left+1), right});
                j++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }
            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            res[i] = map.get(queries[i]);
        }
        return res;
    }
}
