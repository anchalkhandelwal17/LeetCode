class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // TC : O(m*n)   SC : O(m*n) + length of the path
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        } 
        int ans = rec(obstacleGrid, 0, 0, m-1, n-1, dp);
        return ans;
    }
    
    public int rec(int[][] grid, int i, int j, int m, int n, int[][] dp){
        if(i == m && j == n) return 1;
        if(i > m || j > n) return 0;
        if(grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = rec(grid, i+1, j, m, n, dp) + rec(grid, i, j+1, m, n, dp);
    }
}