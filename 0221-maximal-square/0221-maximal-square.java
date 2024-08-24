class Solution {
    public int maximalSquare(char[][] matrix) {
        // TC : O(m*n)
        // SC : O(m*n)
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                    Math.min(dp[i][j-1], dp[i-1][j]));
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}