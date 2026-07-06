class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
       return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int i, int sum){
        if(i == nums.length){
            return sum == target ? 1 : 0;
        }
        String key = i + "-"+sum;
        if(map.containsKey(key))
        return map.get(key);
        int positive = dfs(nums, target, i+1, sum+nums[i]);
        int negative = dfs(nums, target, i+1, sum-nums[i]);

        int ways = positive+negative;
        map.put(key,ways);
        return ways;
    }
}
