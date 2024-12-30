class Solution {
    int mod = (int)(1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        Arrays.fill(dp, -1);

        return (int)solve(0, low, high, zero, one, dp);
    }

    public long solve(int len, int l, int h, int z, int o, long[] dp){

        if(len > h) return 0;

        if(dp[len] != -1) return dp[len];

        long ans = 0;
        if(len >= l) ans += 1;

        ans += solve(len + z, l, h, z, o, dp)
        + solve(len + o, l, h, z, o, dp) ;

        return dp[len] = ans % mod;

    }    
}