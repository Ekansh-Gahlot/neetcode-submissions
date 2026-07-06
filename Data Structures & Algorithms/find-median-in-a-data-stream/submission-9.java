class MedianFinder {

    PriorityQueue<Integer> minHeap;
     PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
        return (minHeap.peek()+maxHeap.peek())/2.0;
        return maxHeap.peek();
    }
}
