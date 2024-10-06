class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        // TC : O(n^2)
        // SC : O(n^2) + O(n*2) + recursion space
        int n = scores.length;
        int[][] sortedByAge = new int[n][2];

        for(int i=0; i<n; i++){
            int score = scores[i];
            int age = ages[i];

            sortedByAge[i][0] = score;
            sortedByAge[i][1] = age;
        }

        Arrays.sort(sortedByAge, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[][] dp = new int[n+1][n+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, -1, sortedByAge, dp);
    }

    public int solve(int i, int prev, int[][] arr, int[][] dp){
        if(i >= arr.length){
            return 0;
        }

        // if cached
        if(prev != -1 && dp[i][prev] != -1){
            return dp[i][prev];
        }

        // not_take
        int not_take = 0 + solve(i+1, prev, arr, dp);

        // take 
        int take = 0;
        if(prev == -1 || arr[i][0] >= arr[prev][0]){
            take = arr[i][0] + solve(i+1, i, arr, dp);
        }

        if(prev != -1){
            dp[i][prev] = Math.max(take, not_take);
        }
        return Math.max(take, not_take);
    }
}