class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp1 = new int[cost.length];
        int[] dp2 = new int[cost.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.min(dfs(cost, 0, dp1), dfs(cost, 1, dp2));
    }
    public int dfs(int[] cost, int i, int[] dp){
        if(i >= cost.length)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        int take1Step = cost[i] + dfs(cost, i+1, dp);
        int take2Step = cost[i] + dfs(cost, i+2, dp);

        int res = Math.min(take1Step, take2Step);
        dp[i] = res;
        return res;
    }
}
