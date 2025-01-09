class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // TC : O(n * 2000)
        // SC : O(n * 2000)

        int n = nums.length;
        int[][] dp = new int[n+1][2001];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, nums, target, 0, dp);
    }

    public int solve(int i, int[] nums, int target, int sum, int[][] dp){
        // if(sum > target) return 0;

        if(i >= nums.length){
            return sum == target ? 1 : 0;
        }

        if(dp[i][sum + 1000] != -1) return dp[i][sum + 1000];

        int plusSign = solve(i+1, nums, target, sum + nums[i], dp);
        int negSign = solve(i+1, nums, target, sum - nums[i], dp);

        return dp[i][sum + 1000] = plusSign + negSign;
    }
}

// we can use pick and not_pick dp
// we can assign +sign before every value
// also we can assign -sign before every value
