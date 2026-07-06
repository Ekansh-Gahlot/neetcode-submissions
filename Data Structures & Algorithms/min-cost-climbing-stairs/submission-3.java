class Solution {
    int[] arr;
    public int minCostClimbingStairs(int[] cost) {
        arr = new int[cost.length];
        Arrays.fill(arr, -1);
        int res = Math.min(dfs(cost,0), dfs(cost,1));
        return res;
        
    }

    public int dfs(int [] cost, int i){
        if(i >= cost.length){
            return 0;
        }

        if(arr[i] != -1)
        return arr[i];

        arr[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost,i+2));
        return arr[i];

        
    }
}
