class Solution {
    public int uniquePaths(int m, int n) {
        
        // int N = m + n -2;
        // int r = m-1;
        // double  ans = 1;

        // for(int i=1; i<=r; i++){
        //     ans = ans * (N - r + i)/i;
        // }
        // return (int)ans;
        int[][] dp = new int[m][n];
        return helper(0,0,m,n, dp);
    }
    public int helper(int i, int j, int m, int n, int[][] dp){
        if(i == m || j == n){
            return 0;
        }
        if(i == m-1 && j== n-1){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        return dp[i][j] = helper(i+1, j, m,n, dp) + helper(i, j+1, m,n, dp);
    }
}