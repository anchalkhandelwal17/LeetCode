class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, 0, 0, dp);
    }

    public int lcs(String a, String b, int i, int j, int[][] dp){
        if(i >= a.length() || j >= b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + lcs(a, b, i + 1, j + 1, dp);
        }

        return dp[i][j] = Math.max(lcs(a, b, i + 1, j, dp), lcs(a, b, i, j + 1, dp));
    }
}

