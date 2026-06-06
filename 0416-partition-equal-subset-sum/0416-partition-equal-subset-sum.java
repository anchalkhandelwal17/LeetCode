class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 == 1) return false;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][sum / 2 + 5];

        return solve(nums, nums.length-1, sum / 2, dp);
    }

    public boolean solve(int[] nums, int i, int sum, Boolean[][] dp){
        // base case
        if(i < 0 || sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(dp[i][sum] != null) return dp[i][sum];

        boolean take = solve(nums, i-1, sum - nums[i], dp);

        boolean not_take = solve(nums, i-1, sum, dp);

        return dp[i][sum] = take || not_take;
    }
}