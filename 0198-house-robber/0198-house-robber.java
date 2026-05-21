class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp){
        // base case
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int idx_plus_two = nums[i] + solve(nums, i+2, dp);
        int idx_plus_one = 0 + solve(nums, i+1, dp);

        return dp[i] = Math.max(idx_plus_two, idx_plus_one);
    }
}