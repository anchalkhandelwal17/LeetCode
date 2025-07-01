class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int prevMin = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            prevMin = Math.min(prevMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - prevMin);
        }
        return maxProfit;
    }
}