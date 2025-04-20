class Solution {
    public int combinationSum4(int[] nums, int target) {
        // TC : O(n * target)
        // SC : O(target)
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(nums, target, dp);
    }

    public int solve(int[] nums, int currSum, int[] dp){
        if(currSum < 0) return 0;
        if(currSum == 0) return 1;
        if(dp[currSum] != -1) return dp[currSum];

        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += solve(nums, currSum - nums[i], dp);
        }

        return dp[currSum] = ans;
    }
}