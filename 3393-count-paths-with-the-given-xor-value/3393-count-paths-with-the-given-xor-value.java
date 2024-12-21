class Solution {
    int mod = (int)(1e9 + 7);
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][305];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int z=0; z<305; z++){
                    dp[i][j][z] = -1;
                }
            }
        }
        
        int ans = dfs(grid, 0, 0, m, n, k, 0, dp);
        return ans%mod;
    }
    
    public int dfs(int[][] grid, int i, int j, int m, int n, int k, int xor, int[][][] dp){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        
        if(dp[i][j][xor] != -1) return dp[i][j][xor];
        
        if(i == m-1 && j == n-1){
            if((xor^grid[i][j]) == k) return 1;
            return 0;
        }
        
        
        int right = dfs(grid, i, j+1, m, n, k, xor^grid[i][j], dp);
        int down = dfs(grid, i+1, j, m, n, k, xor^grid[i][j], dp);
        
        return dp[i][j][xor] = (right + down) % mod;
    }
}