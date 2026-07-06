class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // PriortyQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
         PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        maxHeap.addAll(map.entrySet());

        int[] res = new int[k];

        for(int i = 0 ; i < k ; i++)
        {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }
}
