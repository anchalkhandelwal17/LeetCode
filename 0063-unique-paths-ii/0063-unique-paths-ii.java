class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // TC : O(m * n)
        // SC : O(m * n) + recur space
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, m, n, obstacleGrid, dp);
    }

    public int solve(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i == m-1 && j == n-1 && grid[i][j] == 0){
            return  1;
        }
        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = solve(i+1, j, m, n, grid, dp);
        int right = solve(i, j+1, m, n, grid, dp);

        return dp[i][j] = down + right;
    }
}