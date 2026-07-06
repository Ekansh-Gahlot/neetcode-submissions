class Solution {
    public int distance(int[] a)
    {
        return a[0]*a[0]+a[1]*a[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->distance(b)-distance(a));


        for(int[] point: points)
        {
            maxHeap.offer(point);
            if(maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        int res[][] = new int[k][2];

        for(int i = 0 ; i< k; i++)
        {
            res[i] = maxHeap.poll();
        }
        return res;

    }
}
