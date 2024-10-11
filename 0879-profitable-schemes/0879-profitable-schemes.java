class Solution {
    int mod = (int)(1e9 + 7);
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // TC : O(m * n * minProfit)
        // SC : O(m * n * minProfit) + recursion space
        int m = group.length;
        int[][][] dp = new int[m+1][101][101];

        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar, -1);
            }
        }
        return solve(0, n, minProfit, group, profit, dp);   
    }

    public int solve(int i, int maxPeople, int minProfit, int[] group, int[] profit, 
    int[][][] dp){
        // base case

        if(maxPeople < 0) return 0;

        if(i >= group.length){
            if(minProfit > 0) return 0;
            return 1;
        }

        if(minProfit < 0) minProfit = 0;

        if(dp[i][maxPeople][minProfit] != -1) return dp[i][maxPeople][minProfit];


        int take = solve(i+1, maxPeople - group[i], minProfit - profit[i], group, profit, dp);
        int not_take = solve(i+1, maxPeople, minProfit, group, profit, dp);

        return dp[i][maxPeople][minProfit] = ((take + not_take) % mod);
    }
}