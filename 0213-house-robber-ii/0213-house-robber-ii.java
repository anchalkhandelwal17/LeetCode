class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        int ans1 = solve(nums, 0,  dp);
        Arrays.fill(dp, -1);
        int ans2 = solve2(nums, 1, dp);
        return Math.max(ans1, ans2);
    }
    
    public int solve(int[] nums, int i, int[] dp){
        if(i >= nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];
        
        int take = nums[i] + solve(nums, i+2, dp);
        int notTake = 0 + solve(nums, i+1, dp);
        
        return dp[i] = Math.max(take, notTake);
    }
    
    public int solve2(int[] nums, int i, int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        
        int take = nums[i] + solve2(nums, i+2, dp);
        int notTake = 0 + solve2(nums, i+1, dp);
        
        return dp[i] = Math.max(take, notTake);
    }
}