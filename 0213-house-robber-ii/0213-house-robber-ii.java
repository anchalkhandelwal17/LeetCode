class Solution {
    public int rob(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        if(n == 0) return 0;
        else if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans1 = solve(0, n-1, nums, dp);
        Arrays.fill(dp, -1);
        int ans2 = solve(1, n, nums, dp);
        return Math.max(ans1, ans2);
    }

    public int solve(int i, int n, int[] nums, int[] dp){
        // base condition
        if(i >= n){
            return 0;
        }

        // if dp array already contains ans of a state return it
        if(dp[i] != -1){
            return dp[i];
        }
        // pick this idx and move to idx+2
        int idxPlusTwo = nums[i] + solve(i+2, n, nums, dp);

        // not pick this idx and move to i+1
        int idxPlusOne = 0 + solve(i+1, n, nums, dp);

        return dp[i] = Math.max(idxPlusTwo, idxPlusOne);
    }
}
