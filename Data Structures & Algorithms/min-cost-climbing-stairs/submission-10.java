class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp1 = new int[cost.length];
        int[] dp2 = new int[cost.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int result = Math.min(dfs(cost, 0, dp1), dfs(cost, 1, dp2));
        return result;
    }

    public int dfs(int[] cost, int i, int[] dp){
        if(i >= cost.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];

        int takeOne = cost[i] + dfs(cost, i+1, dp);
        int takeTwo = cost[i] + dfs(cost, i+2, dp);

        int result = Math.min(takeOne, takeTwo);
        dp[i] = result;
        return result;


    }
}
