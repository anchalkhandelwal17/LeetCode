class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalin(s, i, j, dp)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean isPalin(String s, int i, int j, Boolean[][] dp){
        if(i > j){
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = isPalin(s, i+1, j-1, dp);
        }

        return dp[i][j] = false;
    }
}