class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(backTrack(cost,0), backTrack(cost,1));
         
        
    }

    public int backTrack(int[] cost, int i){
        if(i >= cost.length){
            return 0;
        }
        return cost[i] + Math.min(backTrack(cost, i+1), backTrack(cost, i+2));
    }
}
