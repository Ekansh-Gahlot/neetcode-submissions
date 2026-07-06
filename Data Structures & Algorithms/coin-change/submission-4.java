class Solution {
    HashMap<Integer,Integer> map;
    public int coinChange(int[] coins, int amount) {
        map = new HashMap<>();
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    public int dfs(int[] coins, int amount){
        if(amount == 0)
        return 0;
        if(map.containsKey(amount))
        return map.get(amount);
        int result = Integer.MAX_VALUE;
        for(int c: coins){
            if((amount-c)>=0){
                int res = dfs(coins, amount-c);
                if(res!= Integer.MAX_VALUE)
                result = Math.min(1+res, result);
            }
        }
        map.put(amount, result);
        return result;
    }
}
