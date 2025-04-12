class Solution {
    int[] dp = new int[50];
    {
        Arrays.fill(dp, -1);
    }

    public int climbStairs(int n) {
        // TC : O(n)
        // SC : O(n)
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int oneStep = climbStairs(n - 1);
        int twoStep = climbStairs(n - 2);

        return dp[n] = oneStep + twoStep;
    }
}

// at a point i can take 1 step or 2
// so here i have two choices at a particular point of time
// take either a step 1 or take 2 
// and if reached the top return 1 to the ans
// now let's memoize this solution