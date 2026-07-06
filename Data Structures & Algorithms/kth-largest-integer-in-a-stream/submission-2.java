class KthLargest {
    private int k;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>();
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k)
        {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
