package Arrays;

class BuySellStock1 {
    public int maxProfit(int[] prices) {

        int mini = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            ans = Math.max(ans, cost);
            mini = Math.min(mini, prices[i]);
        }

        return ans;
    }
}