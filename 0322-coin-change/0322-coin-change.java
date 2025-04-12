class Solution {
    public int coinChange(int[] coins, int amount) {
        // TC : O(n * amount)
        // SC : O(n * amount)
        int[][] dp = new int[coins.length+1][amount+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int ans = solve(coins, 0, amount, dp);
        return ans >= (int)(1e9) ? -1 : ans;
    }

    public int solve(int[] coins, int idx, int amount, int[][] dp){
        if(amount < 0 || idx >= coins.length){
            return (int)(1e9);
        }
        if(amount == 0){
            return 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = 1 + solve(coins, idx, amount - coins[idx], dp);

        int not_take = 0 + solve(coins, idx+1, amount, dp);

        return dp[idx][amount] = Math.min(take, not_take);
    }
}