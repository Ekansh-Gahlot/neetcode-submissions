class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        int z = 0;
        for(int p[]: points){
            int t = p[0];
            int j = p[1];

            int dis = distance(t,j);
            maxHeap.offer(new int[]{z,dis});
            z++;
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        // int res = maxHeap.poll()[1];
        int result[][] = new int[k][2];
        int p = 0;
        while(!maxHeap.isEmpty()){
            int res = maxHeap.poll()[0];
            result[p] = 
                points[res];

            p++;
        }
        return result;

    }

    public int distance(int i, int j){
        return i*i+j*j;
    }
}
