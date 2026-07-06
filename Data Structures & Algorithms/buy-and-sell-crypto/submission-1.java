class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            int currProfit = 0;
            if(prices[i] > buyingPrice){
                currProfit = prices[i] - buyingPrice;
                if(currProfit > maxProfit) maxProfit = currProfit;
            }
            else{
                buyingPrice = prices[i];
            }
        }
        return maxProfit;

        
    }
}
