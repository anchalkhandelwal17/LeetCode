class Solution {
    public boolean canPartition(int[] nums) {
        // TC : O(quadratic)
        // SC : O(n * sum/2);

        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) sum += nums[i];
        Boolean[][] dp = new Boolean[n][sum/2+1];
        
        return solve(n-1, nums, 0, sum, dp);
    }

    public boolean solve(int i, int[] nums, int currSum, int totalSum, Boolean[][] dp){
        if(currSum - totalSum == 0) return true;
        if(i < 0 || currSum > totalSum) return false;
        if(dp[i][currSum] != null) return dp[i][currSum];

        boolean take = solve(i-1, nums, currSum + nums[i], totalSum - nums[i], dp);
        boolean not_take = solve(i-1, nums, currSum, totalSum, dp);

        return dp[i][currSum] = (take || not_take);
    }
}

// first calc the total sum of arr
// if at any point of time in our rec we get currSum - totalSum == 0 return true
// base case would be 
    // a. if(currSum - totalSum == 0) return true
    // b. if(i < 0) return false
// recurrenece => f(i) = f(take, not_Take) dp;
// then memoize , dp solution is ready