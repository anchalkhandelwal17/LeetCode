class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // TC : quadratic
        // SC : O(n)
        int n = days.length;
        int[] dp = new int[n+2];

        Arrays.fill(dp, -1);
        return solve(n-1, days, costs, dp);
    }

    public int solve(int day, int[] days, int[] costs, int[] dp){
        // base case
        if(day < 0) return 0;
        if(dp[day] != -1) return dp[day];

        int takeFirst = costs[0] + solve(day-1, days, costs, dp);

        int j = day;
        while(j >= 0 && days[j] > days[day] - 7) j--;
        int takeSecond = costs[1] + solve(j, days, costs, dp);

        j = day;
        while(j >= 0 && days[j] > days[day] -30) j--;
        int takeThird = costs[2] + solve(j, days, costs, dp);

        return dp[day] = Math.min(takeFirst, Math.min(takeSecond, takeThird));
    }
}