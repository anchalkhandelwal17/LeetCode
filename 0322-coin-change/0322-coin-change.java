class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int ans = solve(coins, coins.length-1, amount, dp);
        return ans >= (int)(1e8) ? -1 : ans;
    }

    public int solve(int[] coins, int i, int amount, int[][] dp){
        // base case
        if(i < 0 || amount < 0){
            return (int)(1e8);
        }
        if(amount == 0){
            return 0;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = 1 + solve(coins, i, amount - coins[i], dp);
        int not_take = 0 + solve(coins, i-1, amount, dp);

        return dp[i][amount] = Math.min(take, not_take);
    }
}