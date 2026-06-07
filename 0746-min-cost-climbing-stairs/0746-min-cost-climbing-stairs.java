class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // TC : O(n + n)
        // SC : O(n)
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int startWithIdxZero = solve(cost, 0, dp);

        // Arrays.fill(dp, -1);
        int startWithIdxOne = solve(cost, 1, dp);

        return Math.min(startWithIdxZero, startWithIdxOne);
    }

    public int solve(int[] cost, int i, int[] dp){
        // base
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int oneStep = cost[i] + solve(cost, i+1, dp);
        int twoSteps = cost[i] + solve(cost, i+2, dp);

        return dp[i] = Math.min(oneStep, twoSteps);
    }
}

// so we can call our recursive function either from index 0 or index 1
// at every index we could move either 1 step or 2
// and return the min cost to reach top
