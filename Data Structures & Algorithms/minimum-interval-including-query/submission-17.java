class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int q: sortedQueries){
        int j = 0;

            while(j<intervals.length && intervals[j][0] <= q){
                int left = intervals[j][0];
                int right = intervals[j][1];
                minHeap.offer(new int[] {right, (right-left+1)});
                j++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[0] < q){
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.poll()[1]);
        }

        int[] ans = new int[queries.length];
        int k = 0;
        for(int i = 0 ; i < queries.length; i++){
            ans[k] = map.get(queries[i]);
            k++;
        }
        return ans;
    }
}
