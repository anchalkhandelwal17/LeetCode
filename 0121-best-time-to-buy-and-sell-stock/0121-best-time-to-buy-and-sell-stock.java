class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}

// maintain min and max on every iteration in the array
// and calculate maxAns after every iteration