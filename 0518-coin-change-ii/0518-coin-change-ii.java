class Solution {
    public int change(int amount, int[] coins) {
        // TC : exponential
        // SC : O(n * amount) + recursion stack space
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = solve(n-1, amount, coins, dp);
        return ans;
    }
    public int solve(int i, int amount, int[] coins, int[][] dp){
        // base case - smallest possible input
        if(i < 0 || amount < 0) return 0;
        if(amount == 0) return 1;
        if(i == 0){
            if(amount % coins[i] == 0) return 1;
            else return 0;
        }
        if(dp[i][amount] != -1) return dp[i][amount];

        int not_take = solve(i-1, amount, coins, dp);
        int take = solve(i, amount-coins[i], coins, dp);
        return dp[i][amount] = not_take + take;
    }
}