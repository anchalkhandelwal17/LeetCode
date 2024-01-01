class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = helper(n,dp);
        return ans;
    }
    
    public int helper(int n, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return dp[n] = 1;
         if(dp[n] != -1) return dp[n];
        
        int oneStep = helper(n-1,dp);
        int twoStep = helper(n-2,dp);
        return dp[n] = oneStep + twoStep;
    }
}