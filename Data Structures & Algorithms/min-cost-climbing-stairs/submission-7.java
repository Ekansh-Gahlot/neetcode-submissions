class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    public int dfs(int[] cost, int i){
        if(i >= cost.length)
        return 0;

        int take1Step = cost[i] + dfs(cost, i+1);
        int take2Step = cost[i] + dfs(cost, i+2);

        int res = Math.min(take1Step, take2Step);
        return res;
    }
}
