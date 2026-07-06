class Solution {
    HashMap<Integer, Integer> map1 = new HashMap<>();
    HashMap<Integer, Integer> map2 = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {

        int result = Math.min(dfs(cost, 0, map1), dfs(cost, 1, map2));
        return result;
    }

    public int dfs(int[] cost, int i, HashMap<Integer, Integer> map){
        if(i >= cost.length)
        return 0;
        if(map.containsKey(i))
        return map.get(i);

        int takeOne = cost[i] + dfs(cost, i+1, map);
        int takeTwo = cost[i] + dfs(cost, i+2, map);

        int result = Math.min(takeOne, takeTwo);
        map.put(i, result);
        return result;


    }
}
