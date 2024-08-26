class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // TC : quadratic
        // SC : O(k*m*n)
        int k = strs.length;
        int[][] count = new int[k][2];
        int[][][] dp = new int[k+2][m+2][n+2];
        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar, -1);
            }
        }
        for(int i=0; i<k; i++){
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    count[i][0]++;
                }
                else count[i][1]++;
            }
        }
        return solve(0, k, 0, 0, count, m, n, dp);
    }
    public int solve(int i, int k, int countOfA, int countOfB, int[][] count,
    int m, int n, int[][][] dp){
        // base cond
        if(i >= k || countOfA > m || countOfB > n) return 0;

        // if already counted ans for this state simply return
        if(dp[i][countOfA][countOfB] != -1) return dp[i][countOfA][countOfB];

        // then simple pick, not_pick dp
        int not_pick = 0 + solve(i+1, k, countOfA, countOfB, count, m, n, dp);
        int currCountA = countOfA;
        currCountA += count[i][0];
        int currCountB = countOfB;
        currCountB += count[i][1];

        int pick = 0;
        if(currCountA <= m && currCountB <= n){
            pick = 1 + solve(i+1, k, currCountA, currCountB, count, m, n, dp);
        }

        return dp[i][countOfA][countOfB] = Math.max(not_pick, pick);
    }
}

