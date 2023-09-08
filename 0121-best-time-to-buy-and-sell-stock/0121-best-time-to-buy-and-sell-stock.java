class Solution {
    public int maxProfit(int[] prices) {
        // TC : O(n), SC : O(1)

        int mini = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            // calculating the cost for every element, by subtracting it from the min on its left side
            int cost = prices[i]-mini;
            // updating maxProfit if it is less than the current cost
            maxProfit = Math.max(maxProfit, cost);
            // Keep a track of min value on left side
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}