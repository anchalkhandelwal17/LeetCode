class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // TC : O(quadratic)
        // SC : O(m * n) + rec space
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();
        if(m + n != p) return false;
        Boolean[][] dp = new Boolean[m][n];
        return solve(m-1, n-1, p-1, s1, s2, s3, dp);   
    }

    public boolean solve(int i, int j, int k, String a, String b, String c,
    Boolean[][] dp){
        if(i >= 0 && j >= 0 && dp[i][j] != null) return dp[i][j];
        if(k < 0) return true;

        if((i >= 0 && a.charAt(i) == c.charAt(k) && solve(i-1, j, k-1, a, b, c, dp))
        || (j >= 0 && b.charAt(j) == c.charAt(k) && solve(i, j-1, k-1, a, b, c, dp))){
           if(i >= 0 && j >= 0) dp[i][j] = true;
            return true;
        }

        if(i >= 0 && j >= 0) dp[i][j] = false;
        return false;
    }
}
