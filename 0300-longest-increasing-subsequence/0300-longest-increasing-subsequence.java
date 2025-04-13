class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return lis(nums, 0, -1, dp);
    }

    public int lis(int[] nums, int idx, int prev_idx, int[][] dp){

        // base case
        if(idx >= nums.length) return 0;

        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];

        int take = 0;
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            take = 1 + lis(nums, idx+1, idx, dp);
        }

        int not_take = 0 + lis(nums, idx+1, prev_idx, dp);

        return dp[idx][prev_idx+1] = Math.max(take, not_take);
    }
}