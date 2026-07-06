class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());
        while(!map.isEmpty()){
            int firstKey = minHeap.peek();
            for(int i = 0 ; i < groupSize; i++){
                int currKey  = firstKey + i;
                if(!map.containsKey(currKey))
                return false;

                map.put(currKey, map.get(currKey)-1);
                if(map.get(currKey) == 0)
                {
                    map.remove(currKey);
                    if(minHeap.peek() == currKey)
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
