class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
        return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int res = Math.max(dfs(nums, nums.length-2, 0, dp1), dfs(nums, nums.length-1, 1, dp2));
        return res;
    }

    public int dfs(int[] nums, int len, int i, int[] dp){
        if(i > len)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        int rob = nums[i] + dfs(nums, len, i+2, dp);
        int skip = dfs(nums, len, i+1, dp);

        int res = Math.max(rob, skip);
        dp[i] = res;
        return res;
    }
}
