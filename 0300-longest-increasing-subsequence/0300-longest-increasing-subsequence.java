class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = lis(nums, 0, -1, dp);
        return ans;
    }
    
    public int lis(int[] nums, int idx, int prev_idx, int[][] dp){
        if(idx == nums.length){
        return 0;
    }
        if(prev_idx != -1 && dp[idx][prev_idx] != -1) return dp[idx][prev_idx];
        
        int take = 0;
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            take = 1 + lis(nums, idx+1, idx, dp);
        }
        
        int not_take = 0 + lis(nums, idx+1, prev_idx, dp);
        
        if(prev_idx != -1){
            dp[idx][prev_idx] = Math.max(take, not_take);
        }
        return Math.max(take, not_take);
  }
}


