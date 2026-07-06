class Solution {
    public int distance(int[] point){
        return Math.abs(point[0]*point[0] + point[1]*point[1]);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->distance(b)-distance(a));

        for(int[] point: points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0 ; i < res.length; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
