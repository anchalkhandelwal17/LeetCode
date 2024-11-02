class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int x : nums){
            max = Math.max(max, x);
        }

        int[] freq = new int[max+1];
        for(int x : nums){
            freq[x]++;
        }

        int[] dp = new int[max+2];
        Arrays.fill(dp, -1);

        return solve(0, freq, dp);

    }
    
    public int solve(int i, int[] arr, int[] dp){
        // base case
        if(i >= arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int not_take = 0 + solve(i+1, arr, dp);

        int take = arr[i] * i + solve(i+2, arr, dp);

        return dp[i] = Math.max(take, not_take);
    }
}
