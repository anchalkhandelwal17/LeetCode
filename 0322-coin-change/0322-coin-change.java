class Solution {
    public int coinChange(int[] coins, int amount) {
        // TC : O(n * amount)
        // SC : O(n * amount) + rec space
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int ans = solve(0, coins, amount, dp);
        return ans >= 1e8 ? -1 : ans;
    }

    public int solve(int i, int[] coins, int currAmount, int[][] dp){
        // base case
        if(currAmount == 0){
            return 0;
        }
        if(currAmount < 0 || i >= coins.length){
            return (int)(1e8);
        }

        if(dp[i][currAmount] != -1) return dp[i][currAmount];

        int pick = 1 + solve(i, coins, currAmount - coins[i], dp);
        int not_pick = 0 + solve(i+1, coins, currAmount, dp);

        return dp[i][currAmount] = Math.min(pick, not_pick);
    }
}