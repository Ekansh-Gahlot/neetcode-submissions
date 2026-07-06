class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] sortedQueries = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            sortedQueries[i] = queries[i];
        }
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int q: sortedQueries){
            int k = 0;

            while(k < intervals.length && intervals[k][0] <= q){
                int left = intervals[k][0];
                int right = intervals[k][1];
                minHeap.add(new int[]{right-left+1, right});
                k++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }   

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);

        }
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            ans[i] = map.get(queries[i]);
        }
        return ans;
    }
}
