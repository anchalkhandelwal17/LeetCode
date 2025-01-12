class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m+2][n+2][3];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -(int)(1e9);
                }
            }
        }
        return solve(0, 0, m, n, coins, 0, dp);
    }
    
    public int solve(int i, int j, int m, int n, int[][] coins, int count, int[][][] dp){
        if(i >= m || j >= n) return -(int)(1e9);
        if(dp[i][j][count] != -(int)(1e9)) return dp[i][j][count];
        
        if(i == m-1 && j == n-1) {
            if(count < 2 && coins[m-1][n-1] < 0) return 0;
            return coins[m-1][n-1];
        }
        
        int a = -10000000;
        int b = -10000000;
        int c = -10000000;
        int d = -10000000;
        
        a = coins[i][j] + solve(i+1, j, m, n, coins, count, dp);
        if(count < 2 && coins[i][j] < 0){
            b = 0 + solve(i+1, j, m, n, coins, count+1, dp);
        }
        
        c = coins[i][j] + solve(i, j+1, m, n, coins, count, dp);
        if(count < 2 && coins[i][j] < 0){
            d = 0 + solve(i, j+1, m, n, coins, count+1, dp);
        }
        return dp[i][j][count] = Math.max(Math.max(a, b) , Math.max(c, d));
    }
}