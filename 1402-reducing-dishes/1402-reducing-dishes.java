class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction); 
        int n = satisfaction.length;
        int[][] dp = new int[n][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, satisfaction, dp);
    }

    public int solve(int i, int unit, int[] satisfaction, int[][] dp) {
        if (i == satisfaction.length) {
            return 0; 
        }
        
        if (dp[i][unit] != -1) {
            return dp[i][unit];  
        }

        int take = satisfaction[i] * unit + solve(i + 1, unit + 1, satisfaction, dp);
        
        int notTake = solve(i + 1, unit, satisfaction, dp);

        return dp[i][unit] = Math.max(take, notTake);
    }
}

// first sort the arr
// take, not_take can be used
// and max of take, not_take can be returned from every branch of recursion
// f(i, unit)