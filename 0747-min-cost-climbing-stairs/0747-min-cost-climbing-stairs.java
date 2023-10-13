class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] dp = new int[n + 1];
        // dp[0] = cost[0];
        // dp[1] = cost[1];

        // for(int i=2; i<n; i++){
        //     dp[i] = cost [i] + Math.min(dp[i-1] , dp[i-2]);
        // }    
        // return Math.min(dp[n-1], dp[n-2]);


        // Space optimization

        int n = cost.length;
        int a = cost[0];
        int b = cost[1];

        for(int i=2; i<n; i++){
            int curr = cost [i] + Math.min(a , b);
            a = b;
            b = curr;
        }    
        return Math.min(a, b);
    }
}
