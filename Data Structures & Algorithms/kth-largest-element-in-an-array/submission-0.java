class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int n: nums)
        {
            if(minHeap.size() < k)
            {
                minHeap.offer(n);
            }else if(n > minHeap.peek())
            {
                minHeap.offer(n);
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
