class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    public int dfs(int[] coins, int amount, int i){
        if(amount == 0)
        return 0;

        if(dp.containsKey(amount))
        return dp.get(amount);

        int result = Integer.MAX_VALUE;

        for(int c: coins){
            if(amount-c >= 0){
                int res = dfs(coins, amount-c, i+1);
                if(res!=Integer.MAX_VALUE)
                result = Math.min(result, 1+res);
            }
        }
        dp.put(amount, result);
        return result;
    }
}
