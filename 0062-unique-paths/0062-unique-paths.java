// class Solution {
//     public int uniquePaths(int m, int n) {
//         // TC : O(m*n)  SC : O(m*n) + path len
//         int[][] dp = new int[m][n];
//         for(int[] arr : dp) Arrays.fill(arr, -1);
//         int ans = rec(0, 0, m-1, n-1, dp);
//         return ans;
//     }
    
//     public int rec(int i, int j, int m, int n, int[][] dp){
//         if(i == m && j == n) return 1;
//         if(i > m || j > n) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
        
//         return dp[i][j] = rec(i+1, j, m, n, dp) + rec(i, j+1, m, n, dp);
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        // TC : O(m*n)   SC : O(m*n)
        int[][] dp = new int[m][n];
        // dp[m-1][n-1] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int up = 0;
                int left = 0;
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    if(i > 0){
                        up += dp[i-1][j];
                    }
                    if(j > 0){
                        left += dp[i][j-1];
                    }
                dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}