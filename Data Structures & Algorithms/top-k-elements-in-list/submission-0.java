class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result [] = new int[k];

        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else{   
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            
        }
        System.out.println("N F");
        for(int ki: map.keySet()){
            
            System.out.println(ki+" "+map.get(ki));
        }

        // Convert map to a list of map entries
List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

// Sort the list by frequency in descending order
list.sort((a, b) -> b.getValue() - a.getValue());  // Sorting by value (frequency)

// Extract the top k elements
for (int i = 0; i < k; i++) {
    result[i] = list.get(i).getKey();  // Get the key (number) from the sorted list
}
        return result;

    }
}
