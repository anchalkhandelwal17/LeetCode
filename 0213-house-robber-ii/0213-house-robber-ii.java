class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            if(n == 1) return nums[0];
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max1 = solve(nums, 0, n-1, dp);
        Arrays.fill(dp, -1);
        int max2 = solve(nums, 1, n, dp);

        return Math.max(max1, max2);
    }

    public int solve(int[] nums, int i, int n, int[] dp) {
        // base case
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int idx_plus_two = nums[i] + solve(nums, i + 2, n, dp);
        int idx_plus_one = 0 + solve(nums, i + 1, n, dp);

        return dp[i] = Math.max(idx_plus_two, idx_plus_one);
    }
}