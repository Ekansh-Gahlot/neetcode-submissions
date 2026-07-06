class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices) {
        boolean buying = true;
        int profit = dfs(buying, prices, 0);
        return profit;
    }

    public int dfs(boolean buying, int[] prices, int i){
        if(i >= prices.length)
        return 0;

        String key = i+"-"+buying;
        if(map.containsKey(key))
        return map.get(key);

        int cooldown = dfs(buying,prices, i+1);
        int ans;
        if(buying){
            int buy = dfs(false, prices, i+1) - prices[i];
            ans =  Math.max(buy,cooldown);
        }
        else{
            int sell = dfs(true,prices, i+2) + prices[i];
            ans =  Math.max(sell, cooldown);
        }
        map.put(key, ans);
        return ans;
    }
}
