class Solution {
    // HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(dfs(nums, 0, nums.length-1, new HashMap<>()), dfs(nums, 1, nums.length, new HashMap<>()));
    }

    public int dfs(int[] nums, int i, int len,  HashMap<Integer, Integer> map){
        if(i >= len){
            return 0;
        }

        if(map.containsKey(i))
        return map.get(i);

        int rob = nums[i] + dfs(nums, i+2, len, map);
        int skip = dfs(nums, i+1, len, map);

        int res = Math.max(rob, skip);
        map.put(i, res);
        return res;
    }
}
