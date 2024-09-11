class Solution {
    public int minDistance(String word1, String word2) {
        // TC : O(m * n)
        // SC : O(m * n) + rec space
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+2][m+2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(word1.length()-1, word2.length()-1, word1, word2, dp);
    }

    public int solve(int i, int j, String a, String b, int[][] dp){
        // base conditions
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return solve(i-1, j-1, a, b, dp);
        }
        int insert = 1 + solve(i, j-1, a, b, dp);
        int delete = 1 + solve(i-1, j, a, b, dp);
        int replace = 1 + solve(i-1, j-1, a, b, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}

// f(i, j) = Math.min(f(i-1, j-1), Math.min(i, j-1, i-1, j))
// if(a.ch(i) == b.ch(i)) f(i-1, j-1)