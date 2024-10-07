class Solution {
    public int tallestBillboard(int[] rods) {
        // TC : O(n * s) , s => sum of all the elements of s
        // SC : O(n * 2*(s)) + recursion space
        
        int n = rods.length;
        int[][] dp = new int[n+1][10001];
        for(var arr : dp) Arrays.fill(arr, -1);

        return solve(0, 0, rods, dp);
    }

    public int solve(int i, int diff, int[] rods, int[][] dp){
        // base case
        if(i >= rods.length){
            if(diff == 0) return 0;
            return -9999999;
        }
        if(dp[i][diff + 5000] != -1) return dp[i][diff + 5000];

        int not_take = solve(i+1, diff, rods, dp);
        int take1 = rods[i] + solve(i+1, diff+rods[i], rods, dp);
        int take2 = solve(i+1, diff-rods[i], rods, dp);

        return dp[i][diff + 5000] = Math.max(not_take, Math.max(take1, take2));
    }
}