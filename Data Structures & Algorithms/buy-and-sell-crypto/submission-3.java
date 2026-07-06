class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrize = prices[0];

        for(int i = 1; i < prices.length; i++)
        {
            int currProfit = prices[i]-buyingPrize;
            maxProfit = Math.max(currProfit, maxProfit);
            buyingPrize = Math.min(buyingPrize, prices[i]);
        }
        return maxProfit;
    }
}
