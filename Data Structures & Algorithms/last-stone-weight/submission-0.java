class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            maxHeap.offer(s);
        }
        int result = smashStones(stones, maxHeap);
        return result;
    }

    public int smashStones(int[] stones, PriorityQueue<Integer> maxHeap)
    {
        while(maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int smashedStone = Math.abs(a-b);
            if(smashedStone != 0){
                maxHeap.offer(smashedStone);
            }
        }
        if(maxHeap.size() > 0)
        return maxHeap.poll();
        return 0;
    }
}
