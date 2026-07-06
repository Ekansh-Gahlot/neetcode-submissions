class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
    public int[] topKFrequent(int[] nums, int k) {

        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int arr[] = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = minHeap.poll()[0];
        }
        return arr;
        
    }
}
