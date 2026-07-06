class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        
        for(int i = len-3; i >= 0; i--){
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
