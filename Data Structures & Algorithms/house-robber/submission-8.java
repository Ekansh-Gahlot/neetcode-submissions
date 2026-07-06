class Solution {
    int result;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    public int dfs(int[] nums, int i){
        if(i >= nums.length)
        return 0;

        if(map.containsKey(i))
        return map.get(i);

        int rob = nums[i] + dfs(nums, i+2);
        int skip = dfs(nums, i+1);

        result = Math.max(rob, skip);
        map.put(i, result);
        return result;

    }
}
