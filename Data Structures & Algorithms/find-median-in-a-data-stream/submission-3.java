class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty())
        maxHeap.add(num);
        else if(maxHeap.peek() > num)
        maxHeap.add(num);
        else
        minHeap.add(num);

        if(minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size()+1)
        {
            minHeap.add(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
        return (minHeap.peek()+maxHeap.peek())/2.0;
        else
        return maxHeap.peek();
        
    }
}
