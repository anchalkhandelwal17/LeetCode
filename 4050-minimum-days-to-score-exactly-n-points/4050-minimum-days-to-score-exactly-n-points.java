class Solution {
    public int minDays(int n) {
        if(n == 1) return n;
        int[][] dp = new int[480][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = solve(n, 1, 0, dp);
        return ans >= (int)(1e8) ? -1 : ans;
    }

    public int solve(int n, int step, int score, int[][] dp){
        if(score > n){
            return (int)(1e8);
        }
        if(score == n){
            return 0;
        }

        if(dp[step][score] != -1){
            return dp[step][score];
        }

        int take = 1 + solve(n, step+1, score+step, dp);

        int skip = (int)(1e8);
        if(step != 1){
            skip = 1 + solve(n, 1, score, dp);
        }

        return dp[step][score] = Math.min(take, skip);
    }
}