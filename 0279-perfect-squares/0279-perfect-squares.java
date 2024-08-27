class Solution {
    public int numSquares(int n) {
        // TC : quadratic
        // SC : O(sqrt(n) * n)
        int[][] dp = new int[(int)(Math.sqrt(n) + 2)][n+2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(1, 0, n, dp);
    }
    public int solve(int i, int sum, int n, int[][] dp){
        if(sum == n){
            return 0;
        }
        if(sum > n || i*i > n){
            return (int)(1e8);
        }
        if(dp[i][sum] != -1) return dp[i][sum];

        int take = 1 + solve(i, sum + (i * i), n, dp);

        int not_take = solve(i+1, sum, n, dp);
        
        return dp[i][sum] = Math.min(take, not_take);
        // return Math.min(take, not_take);
    }
}
