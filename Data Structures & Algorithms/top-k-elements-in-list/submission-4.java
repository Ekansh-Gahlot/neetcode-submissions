class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());

        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        maxHeap.addAll(map.entrySet());

        int arr[] = new int[k];

        for(int i = 0 ;  i<k; i++){
            arr[i] = maxHeap.poll().getKey();
        }
        return arr;
    }
}
