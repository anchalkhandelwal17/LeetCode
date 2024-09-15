class Solution {
    public boolean canPartition(int[] nums) {
        // TC : quadratic
        // SC : O(n * sum/2)
        int sum = 0;
        for(int x : nums) sum += x;

        if(sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length+2][sum/2+2];

        return solve(0, nums, 0, sum, dp);
    }

    public boolean solve(int i, int[] nums, int currSum, int sum, Boolean[][] dp){
        if(currSum - sum == 0) return true;
        if(i >= nums.length || currSum > sum) return false;
        if(dp[i][currSum] != null) return dp[i][currSum];

        boolean not_take = solve(i+1, nums, currSum, sum, dp);
        boolean take = false;

        if(currSum <= sum){
            take = solve(i+1, nums, currSum + nums[i], sum - nums[i], dp);
        }

        return dp[i][currSum] = take || not_take;
    }
}

// if the sum of the elem of nums is odd then
// no matter what we do we won't be able to partition the array
// but if the sum is even then we may or may not partition the array
// f(i, currSum, sum) = take || not_take
// no. of changing parameters are three in recursion
// so we will be having in total 3 states