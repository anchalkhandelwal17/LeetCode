class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return lis(nums, 0, -1, dp);
    }

    public int lis(int[] nums, int i, int prev_idx, int[][] dp){
        // base;
        if(i >= nums.length){
            return 0;
        }
        if(prev_idx != -1 && dp[i][prev_idx] != -1){
            return dp[i][prev_idx];
        }

        int pick = 0;
        if(prev_idx == -1 || nums[i] > nums[prev_idx]){
            pick = 1 + lis(nums, i+1, i, dp);
        }

        int not_pick = 0 + lis(nums, i+1, prev_idx, dp);

        if(prev_idx != -1){
            dp[i][prev_idx] = Math.max(pick, not_pick);
        }

        return Math.max(pick, not_pick);
    }
}

// i > prev i
// if(i > prev i) still take or not_take cases