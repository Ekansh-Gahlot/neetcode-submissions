class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int result = dfs(nums, 0);
        return result;
    }

    public int dfs(int[] nums, int i){
        if(i >= nums.length)
        return 0;

        if(dp[i] != -1)
        return dp[i];

        int rob = nums[i] + dfs(nums, i+2);
        int skip = dfs(nums, i+1);

        int result = Math.max(rob, skip);
        dp[i] = result;
        return result;
    }

}
