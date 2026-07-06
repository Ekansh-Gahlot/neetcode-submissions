class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {
        int res = dfs(amount, coins, 0);
        return res;
    }

    public int dfs(int amount, int[] coins, int i){
        if(amount == 0)
        return 1;
        String key = i+"-"+amount;
        if(amount < 0 || i >= coins.length)
        return 0;
        if(map.containsKey(key))
        return map.get(key);
        
        int pickCurrent = dfs(amount-coins[i], coins, i);
        int pickNext = dfs(amount, coins, i+1);
        int ways = pickCurrent + pickNext;
        map.put(key, ways);
        return ways;
    }
}
