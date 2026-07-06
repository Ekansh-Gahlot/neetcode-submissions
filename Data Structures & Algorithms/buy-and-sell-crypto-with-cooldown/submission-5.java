class Solution {
    public int maxProfit(int[] prices) {
       return dfs(prices, 0, true);
    }

    public int dfs(int[] prices, int i, boolean canBuy){
        if(i>=prices.length){
            return 0;
        }
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

        return ans;
    }
}
