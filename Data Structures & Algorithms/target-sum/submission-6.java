class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target, 0);
    }

    public int dfs(int i, int[] nums, int target, int sum){
        if(sum == target && i >= nums.length)
        return 1;

        if(i >= nums.length)
        return 0;

        String key = i+"-"+sum;
        if(map.containsKey(key))
        return map.get(key);
        int ways = 0;

        ways = dfs(i+1, nums, target, sum-nums[i]) + dfs(i+1, nums, target, sum+nums[i]);
        map.put(key,ways);
        return ways;
    }
}
