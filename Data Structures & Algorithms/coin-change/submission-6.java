class Solution {
    HashMap<Integer, Integer> dp;
    public int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int[] coins, int amount){
        if(amount == 0)
        return 0;

        if(dp.containsKey(amount))
        return dp.get(amount);

        int res = Integer.MAX_VALUE;
        for(int c: coins){
            if(amount-c>=0){
                int result = dfs(coins, amount-c);
                if(result!=Integer.MAX_VALUE){
                    res = Math.min(1+result, res);
                }
            }
        }
        dp.put(amount, res);
        return res;

    }
}
