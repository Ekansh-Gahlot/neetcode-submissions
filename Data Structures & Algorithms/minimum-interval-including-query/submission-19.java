class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] queriesCopy = new int[queries.length];
        int k = 0;
        for(int i: queries){
            queriesCopy[k] = i;
            k++;
        }
        int j = 0;
        int[] result = new int[queries.length];
        Arrays.sort(queries);
        for(int i: queries){
            while(j < intervals.length && intervals[j][0] <= i){
                int left = intervals[j][0];
                int right = intervals[j][1];
                minHeap.offer(new int[]{right, right-left+1});
                j++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[0] < i){
                minHeap.poll();
            }

            map.put(i, minHeap.isEmpty() ? -1: minHeap.peek()[1]);
        }

        for(int i = 0; i < queries.length; i++){
            result[i] = map.get(queriesCopy[i]);
        }
        return result;
    }
}
