class Solution {
    public int maxProfit(int[] prices) {
        // int maxP = 0;
        // int minBuy = prices[0];

        // for(int sell : prices) {
        //     minBuy = Math.min(minBuy, sell);
        //     maxP = Math.max(maxP, sell-minBuy);
        // }
        // return maxP;

        int l = 0;
        int r = 0;

        int maxP = 0;

        while(r < prices.length) {
            
            if (prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return maxP;
        
    }
}
