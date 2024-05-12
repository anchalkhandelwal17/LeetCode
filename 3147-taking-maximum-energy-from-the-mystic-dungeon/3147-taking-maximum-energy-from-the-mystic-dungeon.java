class Solution {
    public int maximumEnergy(int[] energy, int k) {
        
        int n = energy.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, helper(energy, i, k, dp));
        }
        return ans;
    }
    
    public int helper(int[] energy, int i, int k, int[] dp){
        if(i >= energy.length){
            return 0;
        }
        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }
        dp[i] = energy[i] + helper(energy, i+k, k, dp);
        return dp[i];
    }
}