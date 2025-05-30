class Solution {
    public int maximalSquare(char[][] matrix) {
        // TC : O(m*n)
        // SC : O(m*n) + rec space
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[1];

        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(i, j, matrix, dp, ans);
            }
        }

        return ans[0] * ans[0];
    }

    public int solve(int i, int j, char[][] matrix, int[][] dp, int[] ans) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (matrix[i][j] == '1') {
            int right = solve(i, j + 1, matrix, dp, ans);
            int down = solve(i + 1, j, matrix, dp, ans);
            int diagonal = solve(i + 1, j + 1, matrix, dp, ans);

            dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
            ans[0] = Math.max(ans[0], dp[i][j]);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}
