class Solution {
    public int maxProfit(int[] prices) {

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {

            int oldHold = hold;
            int oldSold = sold;
            int oldRest = rest;

            // Buy or continue holding
            hold = Math.max(oldHold, oldRest - prices[i]);

            // Sell today
            sold = oldHold + prices[i];

            // Stay resting or cooldown ends
            rest = Math.max(oldRest, oldSold);
        }

        return Math.max(sold, rest);
    }
}