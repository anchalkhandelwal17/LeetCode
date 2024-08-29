class Solution {
    public int minCost(int n, int[] cuts) {
        // TC : O(n^3)
        // SC : O(n^2) + stack space
        int k = cuts.length;
        int[] arr = new int[k + 2];
        for (int i = 0; i < k; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[0] = 0;
        arr[k + 1] = n;
        Arrays.sort(arr);

        int[][] dp = new int[k + 2][k + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, k, arr, dp);
    }

    public int solve(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int idx = i; idx <= j; idx++) {
            min = Math.min(min,
                cuts[j + 1] - cuts[i - 1] + solve(i, idx - 1, cuts, dp) + solve(idx + 1, j, cuts, dp));
        }

        return dp[i][j] = min;
    }
}
