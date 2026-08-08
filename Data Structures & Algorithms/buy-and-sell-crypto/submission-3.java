class Solution {
    public int maxProfit(int[] prices) {

        int minBuy = prices[0];
        int maxP = 0;

        for (int sell : prices) {
            minBuy = Math.min(minBuy, sell);
            maxP = Math.max(maxP, sell - minBuy);
        }

        return maxP;
        
    }
}
