class Solution {
    public int minDistance(String word1, String word2) {
        // TC : quadratic
        // SC : O(n * m) + recursion stack space
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return solve(m-1, n-1, word1, word2, dp);
    }
    public int solve(int i, int j, String a, String b, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            return solve(i-1, j-1, a, b, dp);
        }
        int delete = 1 + solve(i-1, j, a, b, dp);
        int replace = 1 + solve(i-1, j-1, a, b, dp);
        int insert = 1 + solve(i, j-1, a, b, dp);
        return dp[i][j] = Math.min(delete, Math.min(replace, insert));
    }
}
// f(i, j)
// base case - if i becomes less than 0  OR if j becomes less than 0 return 
//  f(i, j) => min(f(i-1, j), (i-1, j-1), (i, j-1))