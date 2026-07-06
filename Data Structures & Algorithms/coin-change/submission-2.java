class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int[] coins, int amount){
        if(amount == 0)
        return 0;
        if(map.containsKey(amount))
        return map.get(amount);
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount-coin >= 0){
                int result = dfs(coins, amount-coin);
                if(result != Integer.MAX_VALUE){
                    res = Math.min(1+result, res);
                }
            }
        }
        map.put(amount, res);
        return res;
    }
}
