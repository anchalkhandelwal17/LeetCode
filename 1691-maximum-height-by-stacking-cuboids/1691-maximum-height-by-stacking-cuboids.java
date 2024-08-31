class Solution {
    public int maxHeight(int[][] cuboids) {
        // TC : O(n^2)
        // SC : O(n^2) + recur space
        for(int[] arr : cuboids){
            Arrays.sort(arr);
        }

        Arrays.sort(cuboids, (a, b) -> {
            if (b[2] != a[2]) {
                return b[2] - a[2]; 
            } else if (b[1] != a[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        int n = cuboids.length;
        int[][] dp = new int[n+2][n+2];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, -1, cuboids, dp);
    }

    public int solve(int i, int prev_idx, int[][] cuboids, int[][] dp){
        if(i >= cuboids.length){
            return 0;
        }

        if(prev_idx != -1 && dp[i][prev_idx] != -1) return dp[i][prev_idx];

        int take = 0;
        if(prev_idx == -1 || (cuboids[i][0] <= cuboids[prev_idx][0] &&
        cuboids[i][1] <= cuboids[prev_idx][1] && cuboids[i][2] <= cuboids[prev_idx][2])){
            take = cuboids[i][2] + solve(i+1, i, cuboids, dp);
        }
        int not_take = 0 + solve(i+1, prev_idx, cuboids, dp);

        if(prev_idx != -1){
            dp[i][prev_idx]= Math.max(take, not_take);
        }
        return Math.max(take, not_take);
    }
}