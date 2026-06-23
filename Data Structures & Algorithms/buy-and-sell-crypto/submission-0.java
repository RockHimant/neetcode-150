class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for(int sell : prices) {
            minBuy = Math.min(minBuy, sell);
            maxP = Math.max(maxP, sell-minBuy);
        }
        return maxP;
        
    }
}
