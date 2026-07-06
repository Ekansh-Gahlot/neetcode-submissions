class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices) {
       return dfs(prices, 0, true);
    }

    public int dfs(int[] prices, int i, boolean canBuy){
        if(i>=prices.length){
            return 0;
        }
        String key = i+"-"+canBuy;
        if(map.containsKey(key))
        return map.get(key);
        int ans;
        if(canBuy){
            int buy = -prices[i] + dfs(prices, i+1, false);
            int notBuy = dfs(prices, i+1, true);
            ans = Math.max(buy, notBuy);
        }else{
            int sell = prices[i]+dfs(prices, i+2, true); //cooldown of 1 day
            int hold = dfs(prices,i+1, false);
            ans = Math.max(sell,hold);
        }
        map.put(key, ans);
        return ans;
    }
}
