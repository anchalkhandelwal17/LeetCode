class Solution {
    public int rob(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp) {
        // base case
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + solve(nums, i+2, dp);
        int not_take = 0 + solve(nums, i+1, dp);

        return dp[i] = Math.max(take, not_take);
    }
}