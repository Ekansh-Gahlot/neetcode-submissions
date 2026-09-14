class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;

        for(int q: sortedQueries){
            while(j < intervals.length && intervals[j][0] <= q){
                int right = intervals[j][1];
                int left = intervals[j][0];
                int size = right-left+1;
                minHeap.add(new int[]{right, size});
                j++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[0] < q){
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[1]);
        }

        int ans[] = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            ans[i] = map.get(queries[i]);
        }
        return ans;
    }
}
