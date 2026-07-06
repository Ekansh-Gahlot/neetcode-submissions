class Solution {
    int[] arr;
    public int minCostClimbingStairs(int[] cost) {
        int res = Math.min(dfs(cost,0), dfs(cost,1));
        return res;
        
    }

    public int dfs(int [] cost, int i){
        if(i >= cost.length){
            return 0;
        }

        return cost[i] + Math.min(dfs(cost, i+1), dfs(cost,i+2));
        
    }
}
