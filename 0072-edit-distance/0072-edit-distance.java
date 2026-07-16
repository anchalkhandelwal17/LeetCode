class Solution {
    public int minDistance(String word1, String word2) {
        // TC : O(m*n)
        // SC : O(m*n)
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(word1, word2, 0, 0, dp);
    }

    public int solve(String a, String b, int i, int j, int[][] dp){
        // base case
        if(i >= a.length()){
            return b.length() - j;
        }
        if(j >= b.length()){
            return a.length() - i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(a.charAt(i) == b.charAt(j)){
            return solve(a, b, i+1, j+1, dp);
        }
        int insert = 1 + solve(a, b, i, j+1, dp);
        int delete = 1 + solve(a, b, i+1, j, dp);
        int replace = 1 + solve(a, b, i+1, j+1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}

// need to convert word1 to word2
// three ops are permitted 
// insert, delete, replace

// if char matches in both the strings word1 and word2
// simply move bothe the pointers i and j
// otherwise try to insert, delete and replace as well
// and take min ans