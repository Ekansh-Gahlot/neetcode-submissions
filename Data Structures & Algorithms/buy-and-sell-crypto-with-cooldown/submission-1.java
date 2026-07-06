class Solution {
    public int maxProfit(int[] prices) {
        boolean buying = true;
        int profit = dfs(buying, prices, 0);
        return profit;
    }

    public int dfs(boolean buying, int[] prices, int i){
        if(i >= prices.length)
        return 0;

        int cooldown = dfs(buying,prices, i+1);
        if(buying){
            int buy = dfs(false, prices, i+1) - prices[i];
            return Math.max(buy,cooldown);
        }
        else{
            int sell = dfs(true,prices, i+2) + prices[i];
            return Math.max(sell, cooldown);
        }
    }
}
