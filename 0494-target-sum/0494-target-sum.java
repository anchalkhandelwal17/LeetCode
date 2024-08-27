class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // TC : O(n^2)
        // SC : O(n*2005)
        int[][] dp = new int[nums.length + 2][2005];
        for(int[] arr : dp){
            Arrays.fill(arr, (int)(1e6));
        }
        return solve(0, 0, nums, target, dp);
    }

    public int solve(int i, int sum, int[] nums, int target, int[][] dp){
        // base condition
        if(i >= nums.length){
            if(sum == target) return 1;
            else return 0;
        }
        if(sum < 0){
            if(dp[i][1000 + Math.abs(sum)] != (int)(1e6)) return dp[i][1000 + Math.abs(sum)];
        }
        if(sum >= 0) if(dp[i][sum] != (int)(1e6)) return dp[i][sum];

        int take = 0 + solve(i+1, sum+nums[i], nums, target, dp);
        int not_take = 0 + solve(i+1, sum-nums[i], nums, target, dp);

        if(sum < 0){
            dp[i][1000 + Math.abs(sum)] = take + not_take;
        }
        else dp[i][sum] = take + not_take;
        return take + not_take; 
    }
}

// the possibility of sum that is equal to target should include all numbers in arr
// f(nums, target, i, sum) = sum(0 + f(num, target, i+1, sum+nums[i],
//                           0 + f(nums, target, i+1, sum-nums[i])));
// base case => if(i >= n) => if(sum == t) return 1 else return 0  