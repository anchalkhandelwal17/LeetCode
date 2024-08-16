class Solution {
    public int climbStairs(int n) {
        // TC : O(n)
        // SC : O(n)
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int distinctWays = solve(0, n, dp);
        return distinctWays;
    }
    public int solve(int i, int n, int[] dp){
        if(i > n) return 0;
        if(i == n) return 1;
        if(dp[i] != -1) return dp[i];

        int oneStep = solve(i+1, n, dp);
        int twoSteps = solve(i+2, n, dp);
        return dp[i] = oneStep + twoSteps;
    }
}