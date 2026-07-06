class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(), a.getValue()));
    public int[] topKFrequent(int[] nums, int k) {
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }
}
