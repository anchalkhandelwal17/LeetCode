class Solution {
    public int rob(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans1 = solve(nums, 0, n-1, dp);
        Arrays.fill(dp, -1);
        int ans2 = solve(nums, 1, n, dp);
        return Math.max(ans1, ans2);
    }

    public int solve(int[] nums, int i, int n, int[] dp){
        // base case
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(nums, i+2, n, dp);
        int not_take = 0 + solve(nums, i+1, n, dp);

        return dp[i] = Math.max(take, not_take);
    }
}