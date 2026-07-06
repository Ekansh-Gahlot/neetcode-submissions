class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
   
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

        
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
        return (maxHeap.peek() + minHeap.peek())/2.0;
        else 
        return maxHeap.peek();
    }
}
