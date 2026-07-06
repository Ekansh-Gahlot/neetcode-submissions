class Solution {
    public int distance(int[] point){
            return point[0] * point[0] + point[1] * point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        //1. Calculate distance of each point from origin
        //2. Make a max heap of size k, and store the distances to the heap
        

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(distance(b),distance(a)));

        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        for(int[] point : maxHeap){
            result[index++] = point;
        }
        return result;

    }
    
}
