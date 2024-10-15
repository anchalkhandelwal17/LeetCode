class Solution {
    public int minPathSum(int[][] grid) {
        // TC : O(m * n)
        // SC : O(m * n)
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+2][n+2];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        if(m == 0 || n == 0) return 0;

        int minPathSum = dfs(m-1, n-1, grid, dp);
        return minPathSum;
    }
    public int dfs(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0){
            return (int)(1e9);
        }
        if(dp[i][j] != -1) return dp[i][j];
         
        int top = grid[i][j] + dfs(i-1, j, grid, dp);
        int left = grid[i][j] + dfs(i, j-1, grid, dp);

        return dp[i][j] = Math.min(top, left);
    }
}



//                  dfs(2,2) = 7
//                /           \
//          dfs(1,2) = 8      dfs(2,1) = 7
//          /    \              /     \
// dfs(0,2) = 5  dfs(1,1) = 8  dfs(1,1) = 8 dfs(2,0) = 12
//      /  \        /    \              /    \
// dfs(0,1)= 4 dfs(1,0)= 2 dfs(0,1) = 4 dfs(1,0)= 2
//    /   \        /   \                  /   \
// dfs(0,0)=1 dfs(0,0)=1            dfs(0,0) = 1
