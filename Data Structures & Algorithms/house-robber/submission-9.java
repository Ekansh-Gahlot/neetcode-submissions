class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);   
        int res = dfs(nums, 0, dp);
        return res;
    }


    public int dfs(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i]!=-1)
        return dp[i];

        int rob = nums[i] + dfs(nums, i+2, dp);
        int skip = dfs(nums, i+1, dp);

        int money = Math.max(rob, skip);
        dp[i] = money;

        return money;
    }
}
