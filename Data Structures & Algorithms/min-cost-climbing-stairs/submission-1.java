class Solution {
    int[] arr;
    public int minCostClimbingStairs(int[] cost) {
        arr = new int[cost.length];
        Arrays.fill(arr, -1);
        return Math.min(backTrack(cost, 0), backTrack(cost, 1));
    }

    public int backTrack(int[] cost, int i){
        if(i >= cost.length){
            return 0;
        }

        if(arr[i] != -1){
            return arr[i];
        }
        arr[i] = cost[i] + Math.min(backTrack(cost, i+1), backTrack(cost, i+2));
        return arr[i];
    }
}
